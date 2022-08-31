package com.ericklemos.planetario.core.utils;

import com.ericklemos.planetario.core.exceptions.ValidationException;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Validator<T> {

    static <T> Validator<T> ofType(Class<T> tipo) {
        return valor -> () -> tipo.cast(valor);
    }

    ValidatorSupplier<T> supplier(T valor);

    default Validator<T> addRegra(Predicate<T> predicate, String errorMessage) {
        return valor -> {

            if (Objects.isNull(valor)) {
                return () -> {
                    throw new ValidationException("objeto não pode ser nulo");
                };
            }

            try {

                supplier(valor).get();

                if (predicate.test(valor)) {
                    return () -> valor;
                }

                return () -> {
                    throw buildExceptionInicial(errorMessage);
                };

            } catch (ValidationException validationException) {

                if (!predicate.test(valor)) {
                    validationException.addSuppressed(new IllegalArgumentException(errorMessage));
                }

                return () -> {
                    throw buildException(errorMessage, validationException);
                };

            } catch (NullPointerException nullPointerException) {

                nullPointerException.addSuppressed(new NullPointerException(errorMessage));

                return () -> {
                    throw buildException(errorMessage, nullPointerException);
                };
            }
        };
    }

    private ValidationException buildExceptionInicial(String errorMessage) {
        var exception = new ValidationException("Objeto nao e valido: " + errorMessage);
        exception.addSuppressed(new IllegalArgumentException(errorMessage));
        return exception;
    }

    private ValidationException buildException(String errorMessage, RuntimeException validationException) {
        var mensagemException = validationException.getMessage() + ", " + errorMessage;
        var exception = new ValidationException(validationException, mensagemException);
        Arrays.stream(validationException.getSuppressed()).forEach(exception::addSuppressed);
        return exception;
    }


    interface ValidatorSupplier<T> extends Supplier<T> {
        default T validar() {
            if (Optional.ofNullable(get()).isEmpty()) {
                throw new ValidationException("objeto não pode ser nulo");
            }
            return get();
        }
    }

}
