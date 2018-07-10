package com.web.clients.demoserver.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
public interface PictureStorageService {

    /**
     * Check existence of file in storage
     *
     * @param filename filename for checking
     * @return true if file exist
     */
    boolean isExistInStorage(String filename);

    /**
     * @return count of files in storage
     */
    int getFilesCount();

    /**
     * Loading new file to storage
     *
     * @param picture file for loading
     * @return filename
     */
    String upload(MultipartFile picture);

    /**
     * @param filename filename for downloading
     * @return file like {@link Resource}
     */
    Resource download(String filename);
}
