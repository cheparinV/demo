package com.web.clients.demoserver.dto;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
public class ErrorDto {

    private String message;
    private String code;

    public String getMessage() {
        return message;
    }

    public ErrorDto setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ErrorDto setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public String toString() {
        return "ErrorDto{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
