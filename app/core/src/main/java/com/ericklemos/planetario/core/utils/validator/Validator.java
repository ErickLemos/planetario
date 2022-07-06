package com.ericklemos.planetario.core.utils.validator;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Validator<T> {

    static <T> Validator<T> ofType(Class<T> tipo) {
        return p -> () -> tipo.cast(p);
    }

    ValidatorSupplier<T> supplier(T p);

    default Validator<T> addRegra(Predicate<T> predicate, String errorMessage) {
        return addRegraBase(predicate, errorMessage, false);
    }

    default Validator<T> addRegra(Predicate<T> predicate, String errorMessage, boolean eCritico) {
        return addRegraBase(predicate, errorMessage, eCritico);
    }

    private Validator<T> addRegraBase(Predicate<T> predicate, String errorMessage, boolean eCritico) {
        return valor -> {
            try {

                supplier(valor).get();
                if (predicate.test(valor)) {
                    return () -> valor;
                }

                return () -> {
                    var exception = new ValidationException("Objeto nao e valido: " + errorMessage);
                    exception.addSuppressed(new IllegalArgumentException(errorMessage));
                    throw exception;
                };

            } catch (ValidationException validationException) {

                if (!predicate.test(valor)) {
                    validationException.addSuppressed(new IllegalArgumentException(errorMessage));
                }

                return () -> {
                    var mensagemException = validationException.getMessage() + ", " + errorMessage;
                    var exception = new ValidationException(validationException, mensagemException);

                    Arrays.stream(validationException.getSuppressed()).forEach(exception::addSuppressed);

                    throw exception;
                };

            }
        };
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
