package com.ericklemos.planetario.core.exceptions;

public class EntidadeNaoEncontradaException extends RuntimeException {

    public EntidadeNaoEncontradaException() {
        super("entidade não foi encontrada");
    }

}
