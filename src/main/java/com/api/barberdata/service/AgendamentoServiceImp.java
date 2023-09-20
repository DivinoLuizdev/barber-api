package com.api.barberdata.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.barberdata.domain.Agendamento;
import com.api.barberdata.repository.AgendamentoRepository;
import com.api.barberdata.service.interfaces.GenericService;
/**
 * Implementação da interface GenericService para Agendamentos.
 * Esta classe fornece operações CRUD (Create, Read, Update, Delete) para Agendamentos.
 * Ela é responsável por interagir com o repositório de Agendamentos e realizar as operações necessárias.
 */
@Service
public class AgendamentoServiceImp implements GenericService<Agendamento> {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    /**
     * Obtém todos os Agendamentos.
     *
     * @return Uma lista de Agendamentos.
     */
    @Override
    public Iterable<Agendamento> buscarTodos() {
        return agendamentoRepository.findAll();
    }

    /**
     * Obtém um Agendamento pelo seu ID.
     *
     * @param id O ID do Agendamento a ser buscado.
     * @return Um Optional contendo o Agendamento encontrado, ou vazio se não encontrado.
     */
    @Override
    public Optional<Agendamento> buscaPorId(Long id) {
        return agendamentoRepository.findById(id);
    }

    /**
     * Insere um novo Agendamento.
     *
     * @param agendamento O Agendamento a ser inserido.
     */
    @Override
    public void inserir(Agendamento agendamento) {
        agendamentoRepository.save(agendamento);
    }

    /**
     * Atualiza um Agendamento pelo seu ID.
     *
     * @param id          O ID do Agendamento a ser atualizado.
     * @param agendamento O Agendamento com as informações atualizadas.
     */
    @Override
    public void atualizar(Long id, Agendamento agendamento) {
        Optional<Agendamento> agendamentoBd = agendamentoRepository.findById(id);
        if (agendamentoBd.isPresent()) {
            agendamentoRepository.save(agendamento);
        }
    }

    /**
     * Deleta um Agendamento pelo seu ID.
     *
     * @param id O ID do Agendamento a ser deletado.
     */
    @Override
    public void deletar(Long id) {
        agendamentoRepository.deleteById(id);
    }
}
