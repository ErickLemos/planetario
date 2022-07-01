package com.ericklemos.planetario.core.utils.validator;

import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Validator<T> {

    static <R> Validator<R> ofType(Class<R> valor) {
        return p -> () -> (R) valor;
    }

    Supplier<T> supplier(T p);

    default Validator<T> addValidacao(Predicate<T> predicate, String errorMessage) {
        return p -> {
            try {
                supplier(p).get();
                if (predicate.test(p)) {
                    return () -> p;
                } else {
                    return () -> {
                        var exception = new ValidationException("Objeto nao e valido");
                        exception.addSuppressed(new IllegalArgumentException(errorMessage));
                        throw exception;
                    };
                }
            } catch (ValidationException validationException) {
                if (!predicate.test(p)) {
                    validationException.addSuppressed(new IllegalArgumentException(errorMessage));
                }
                return () -> {
                    throw validationException;
                };
            }
        };
    }

}
