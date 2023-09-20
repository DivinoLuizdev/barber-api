package com.api.barberdata.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.barberdata.domain.ContasReceber;
import com.api.barberdata.repository.ContasReceberRepository;

import com.api.barberdata.service.interfaces.GenericService;
/**
 * Implementação da interface GenericService para Contas a Receber.
 * Esta classe fornece operações CRUD (Create, Read, Update, Delete) para Contas a Receber.
 * Ela é responsável por interagir com o repositório de Contas a Receber e realizar as operações necessárias.
 */
@Service
public class ContasReceberServiceImp implements GenericService<ContasReceber> {

    @Autowired
    private ContasReceberRepository contasReceberRepository;

    /**
     * Obtém todas as Contas a Receber.
     *
     * @return Uma lista de Contas a Receber.
     */
    @Override
    public Iterable<ContasReceber> buscarTodos() {
        return contasReceberRepository.findAll();
    }

    /**
     * Obtém uma Conta a Receber pelo seu ID.
     *
     * @param id O ID da Conta a Receber a ser buscada.
     * @return Um Optional contendo a Conta a Receber encontrada, ou vazio se não encontrada.
     */
    @Override
    public Optional<ContasReceber> buscaPorId(Long id) {
        return contasReceberRepository.findById(id);
    }

    /**
     * Insere uma nova Conta a Receber.
     *
     * @param contasReceber A Conta a Receber a ser inserida.
     */
    @Override
    public void inserir(ContasReceber contasReceber) {
        contasReceberRepository.save(contasReceber);
    }

    /**
     * Atualiza uma Conta a Receber pelo seu ID.
     *
     * @param id             O ID da Conta a Receber a ser atualizada.
     * @param contasReceber  A Conta a Receber com as informações atualizadas.
     */
    @Override
    public void atualizar(Long id, ContasReceber contasReceber) {
        Optional<ContasReceber> contasReceberBd = contasReceberRepository.findById(id);
        if (contasReceberBd.isPresent()) {
            contasReceberRepository.save(contasReceber);
        }
    }

    /**
     * Deleta uma Conta a Receber pelo seu ID.
     *
     * @param id O ID da Conta a Receber a ser deletada.
     */
    @Override
    public void deletar(Long id) {
        contasReceberRepository.deleteById(id);
    }
}
