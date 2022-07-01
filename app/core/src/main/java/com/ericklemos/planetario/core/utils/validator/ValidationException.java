package com.ericklemos.planetario.core.utils.validator;

public class ValidationException extends RuntimeException {

    public ValidationException(String errorMessage) {
        super(errorMessage);
    }

}
