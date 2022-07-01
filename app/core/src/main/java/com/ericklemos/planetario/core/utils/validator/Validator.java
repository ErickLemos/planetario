package com.ericklemos.planetario.core.utils.validator;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Validator<T> {

    static <R> Validator<R> ofType(Class<R> valor) {
        return p -> () -> (R) valor;
    }

    ValidatorSupplier<T> supplier(T p);

    default Validator<T> addRegra(Predicate<T> predicate, String errorMessage) {
        return objeto -> {

            cancelarCasoObjetoSejaNulo(objeto);

            try {
                supplier(objeto).get();
                if (predicate.test(objeto)) {
                    return () -> objeto;
                } else {
                    return () -> {
                        var exception = new ValidationException("Objeto nao e valido: " + errorMessage);
                        exception.addSuppressed(new IllegalArgumentException(errorMessage));
                        throw exception;
                    };
                }
            } catch (ValidationException validationException) {
                if (!predicate.test(objeto)) {
                    validationException.addSuppressed(new IllegalArgumentException(errorMessage));
                }
                return () -> {
                    var mensagemException = validationException.getMessage() + ", " + errorMessage;
                    throw new ValidationException(validationException, mensagemException);
                };
            }
        };
    }

    private void cancelarCasoObjetoSejaNulo(T objeto) {
        if (Optional.ofNullable(objeto).isEmpty()) {
            throw new ValidationException("objeto não pode ser nulo");
        }
    }

    interface ValidatorSupplier<T> extends Supplier<T> {
        default T validar() {
            return get();
        }
    }

}
