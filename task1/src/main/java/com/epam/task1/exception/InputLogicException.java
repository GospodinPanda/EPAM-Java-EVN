package com.epam.task1.exception;

public class InputLogicException extends Exception {
    public InputLogicException() {
        super();
    }

    public InputLogicException(String message) {
        super(message);
    }

    public InputLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputLogicException(Throwable cause) {
        super(cause);
    }

    protected InputLogicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
