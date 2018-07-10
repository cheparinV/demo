package com.web.clients.demoserver.service.impl;

import com.web.clients.demoserver.exception.IncorrectContentTypeException;
import com.web.clients.demoserver.service.PictureStorageService;
import com.web.clients.demoserver.service.utils.StorageConfig;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
@Service
public class PictureStorageServiceImpl implements PictureStorageService {

    private final Path storagePath;
    private int filesCount = 0;

    private final String PNG = "image/png";
    private final String JPG = "image/jpg";

    public PictureStorageServiceImpl(StorageConfig config) {
        this.storagePath = Paths.get(config.getDir());
    }

    @PostConstruct
    public void init() {
        try {
            if (!Files.exists(this.storagePath)) {
                Files.createDirectories(this.storagePath);
                this.filesCount = 0;
            } else {
                this.filesCount = (int) Files.walk(this.storagePath, 1)
                        .filter(path -> !path.equals(this.storagePath))
                        .map(this.storagePath::relativize)
                        .count();
            }

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String upload(MultipartFile picture) {
        this.checkImageType(picture);
        String filename = StringUtils.cleanPath(picture.getOriginalFilename());
        final boolean exists = this.isExistInStorage(filename);
        try (InputStream inputStream = picture.getInputStream()) {
            Files.copy(inputStream, this.storagePath.resolve(filename),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!exists) {
            this.filesCount++;
        }
        return filename;
    }

    @Override
    public Resource download(String filename) {
        final Path path = this.storagePath.resolve(filename);
        try {
            final UrlResource resource = new UrlResource(path.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new IllegalArgumentException("Incorrect filename");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Incorrect file");
        }
    }

    @Override
    public boolean isExistInStorage(String filename) {
        return Files.exists(this.storagePath.resolve(filename));
    }

    @Override
    public int getFilesCount() {
        return filesCount;
    }

    private void checkImageType(MultipartFile picture) {
        final String type = picture.getContentType();
        if (!type.equals(PNG) && !type.equals(JPG)) {
            throw new IncorrectContentTypeException("Not compatible picture format: " + type);
        }
    }
}
