package com.web.clients.demoserver.exception;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
public class IncorrectContentTypeException extends RuntimeException {

    private final String message;

    public IncorrectContentTypeException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
