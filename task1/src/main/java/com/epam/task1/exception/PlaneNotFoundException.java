package com.epam.task1.exception;

public class PlaneNotFoundException extends Exception {
    public PlaneNotFoundException() {
        super();
    }

    public PlaneNotFoundException(String message) {
        super(message);
    }

    public PlaneNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlaneNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PlaneNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
