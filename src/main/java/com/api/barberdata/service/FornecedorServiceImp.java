package com.api.barberdata.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.barberdata.domain.Fornecedor;
import com.api.barberdata.repository.FornecedorRepository;
import com.api.barberdata.service.interfaces.GenericService;

/**
 * Implementação da interface GenericService para Fornecedores.
 * Esta classe fornece operações CRUD (Create, Read, Update, Delete) para Fornecedores.
 * Ela é responsável por interagir com o repositório de Fornecedores e realizar as operações necessárias.
 */
@Service
public class FornecedorServiceImp implements GenericService<Fornecedor> {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    /**
     * Obtém todos os Fornecedores.
     *
     * @return Uma lista de Fornecedores.
     */
    @Override
    public Iterable<Fornecedor> buscarTodos() {
        return fornecedorRepository.findAll();
    }

    /**
     * Obtém um Fornecedor pelo seu ID.
     *
     * @param id O ID do Fornecedor a ser buscado.
     * @return Um Optional contendo o Fornecedor encontrado, ou vazio se não encontrado.
     */
    @Override
    public Optional<Fornecedor> buscaPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    /**
     * Insere um novo Fornecedor.
     *
     * @param fornecedor O Fornecedor a ser inserido.
     */
    @Override
    public void inserir(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
    }

    /**
     * Atualiza um Fornecedor pelo seu ID.
     *
     * @param id         O ID do Fornecedor a ser atualizado.
     * @param fornecedor O Fornecedor com as informações atualizadas.
     */
    @Override
    public void atualizar(Long id, Fornecedor fornecedor) {
        Optional<Fornecedor> fornecedorBd = fornecedorRepository.findById(id);
        if (fornecedorBd.isPresent()) {
            fornecedorRepository.save(fornecedor);
        }
    }

    /**
     * Deleta um Fornecedor pelo seu ID.
     *
     * @param id O ID do Fornecedor a ser deletado.
     */
    @Override
    public void deletar(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
