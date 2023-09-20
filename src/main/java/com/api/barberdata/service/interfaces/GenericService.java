package com.api.barberdata.service.interfaces;

import java.util.Optional;

public interface GenericService<T> {

    Iterable<T> buscarTodos();

    Optional<T> buscaPorId(Long id);

    void inserir(T entity);

    void atualizar(Long id, T entity);

    void deletar(Long id);
}
