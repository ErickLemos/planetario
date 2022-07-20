package com.ericklemos.planetario.core.exceptions;

public class ValidationException extends RuntimeException {

    public ValidationException(Throwable cause, String message) {
        super(message, cause);
    }

    public ValidationException(String errorMessage) {
        super(errorMessage);
    }

}
