package com.web.clients.demoserver.rest;

import com.web.clients.demoserver.service.PictureStorageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
@RestController
@RequestMapping("/picture")
public class PictureController {

    private final PictureStorageService service;

    @Autowired
    public PictureController(PictureStorageService service) {
        this.service = service;
    }

    @ApiOperation("Download picture by filename")
    @GetMapping
    public Resource downloadPicture(@RequestParam String filename) {
        return service.download(filename);
    }
}
