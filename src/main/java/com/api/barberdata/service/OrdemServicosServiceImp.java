package com.api.barberdata.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.barberdata.domain.OrdemServicos;
import com.api.barberdata.repository.OrdemServicosRepository;
import com.api.barberdata.service.interfaces.GenericService;
/**
 * Implementação da interface GenericService para Ordens de Serviço.
 * Esta classe fornece operações CRUD (Create, Read, Update, Delete) para Ordens de Serviço.
 * Ela é responsável por interagir com o repositório de Ordens de Serviço e realizar as operações necessárias.
 */
@Service
public class OrdemServicosServiceImp implements GenericService<OrdemServicos> {

    @Autowired
    private OrdemServicosRepository ordemServicosRepository;

    /**
     * Obtém todas as Ordens de Serviço.
     *
     * @return Uma lista de Ordens de Serviço.
     */
    @Override
    public Iterable<OrdemServicos> buscarTodos() {
        return ordemServicosRepository.findAll();
    }

    /**
     * Obtém uma Ordem de Serviço pelo seu ID.
     *
     * @param id O ID da Ordem de Serviço a ser buscada.
     * @return Um Optional contendo a Ordem de Serviço encontrada, ou vazio se não encontrada.
     */
    @Override
    public Optional<OrdemServicos> buscaPorId(Long id) {
        return ordemServicosRepository.findById(id);
    }

    /**
     * Insere uma nova Ordem de Serviço.
     *
     * @param ordemServicos A Ordem de Serviço a ser inserida.
     */
    @Override
    public void inserir(OrdemServicos ordemServicos) {
        ordemServicosRepository.save(ordemServicos);
    }

    /**
     * Atualiza uma Ordem de Serviço pelo seu ID.
     *
     * @param id            O ID da Ordem de Serviço a ser atualizada.
     * @param ordemServicos A Ordem de Serviço com as informações atualizadas.
     */
    @Override
    public void atualizar(Long id, OrdemServicos ordemServicos) {
        Optional<OrdemServicos> ordemServicosBd = ordemServicosRepository.findById(id);
        if (ordemServicosBd.isPresent()) {
            ordemServicosRepository.save(ordemServicos);
        }
    }

    /**
     * Deleta uma Ordem de Serviço pelo seu ID.
     *
     * @param id O ID da Ordem de Serviço a ser deletada.
     */
    @Override
    public void deletar(Long id) {
        ordemServicosRepository.deleteById(id);
    }
}
