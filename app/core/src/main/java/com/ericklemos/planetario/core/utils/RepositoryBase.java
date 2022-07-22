package com.ericklemos.planetario.core.utils;

import java.util.List;
import java.util.Optional;

public interface RepositoryBase<T> {

    List<T> buscarTodos();

    Optional<T> buscarPorId(String id);

    T salvar(T planeta);

    void excluirPorId(String id);

}
