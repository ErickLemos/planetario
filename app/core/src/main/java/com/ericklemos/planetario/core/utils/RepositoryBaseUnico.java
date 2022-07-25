package com.ericklemos.planetario.core.utils;

import java.util.Optional;

public interface RepositoryBaseUnico<T> {

    Optional<T> buscarPorId(String id);

    T salvar(T obj);

    void excluirPorId(String id);

}
