package com.api.barberdata.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.barberdata.model.ContasPaga;
import com.api.barberdata.repository.ContasPagaRepository;
import com.api.barberdata.service.interfaces.GenericService;
/**
 * Implementação da interface GenericService para ContasPaga.
 * Esta classe fornece operações CRUD (Create, Read, Update, Delete) para ContasPaga.
 * Ela é responsável por interagir com o repositório de ContasPaga e realizar as operações necessárias.
 */
@Service
public class ContasPagaServiceImp implements GenericService<ContasPaga> {

    @Autowired
    private ContasPagaRepository contasPagaRepository;

    /**
     * Obtém todas as ContasPaga.
     *
     * @return Uma lista de ContasPaga.
     */
    @Override
    public Iterable<ContasPaga> buscarTodos() {
        return contasPagaRepository.findAll();
    }

    /**
     * Obtém uma ContasPaga pelo seu ID.
     *
     * @param id O ID da ContasPaga a ser buscada.
     * @return Um Optional contendo a ContasPaga encontrada, ou vazio se não encontrada.
     */
    @Override
    public Optional<ContasPaga> buscaPorId(Long id) {
        return contasPagaRepository.findById(id);
    }

    /**
     * Insere uma nova ContasPaga.
     *
     * @param contasPaga A ContasPaga a ser inserida.
     */
    @Override
    public void inserir(ContasPaga contasPaga) {
        contasPagaRepository.save(contasPaga);
    }

    /**
     * Atualiza uma ContasPaga pelo seu ID.
     *
     * @param id         O ID da ContasPaga a ser atualizada.
     * @param contasPaga A ContasPaga com as informações atualizadas.
     */
    @Override
    public void atualizar(Long id, ContasPaga contasPaga) {
        Optional<ContasPaga> contasPagaBd = contasPagaRepository.findById(id);
        if (contasPagaBd.isPresent()) {
            contasPagaRepository.save(contasPaga);
        }
    }

    /**
     * Deleta uma ContasPaga pelo seu ID.
     *
     * @param id O ID da ContasPaga a ser deletada.
     */
    @Override
    public void deletar(Long id) {
        contasPagaRepository.deleteById(id);
    }
}
