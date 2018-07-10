package com.web.clients.demoserver.service.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
@ConfigurationProperties("storage")
@Component
public class StorageConfig {

    private String dir = "upload-dir";

    public String getDir() {
        return dir;
    }

    public StorageConfig setDir(String dir) {
        this.dir = dir;
        return this;
    }
}
