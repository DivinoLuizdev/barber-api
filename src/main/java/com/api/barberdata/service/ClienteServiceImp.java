package com.api.barberdata.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.barberdata.domain.Cliente;
import com.api.barberdata.repository.ClienteRepository;
import com.api.barberdata.service.interfaces.GenericService;
/**
 * Implementação da interface GenericService para Clientes.
 * Esta classe fornece operações CRUD (Create, Read, Update, Delete) para Clientes.
 * Ela é responsável por interagir com o repositório de Clientes e realizar as operações necessárias.
 */
@Service
public class ClienteServiceImp implements GenericService<Cliente> {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Obtém todos os Clientes.
     *
     * @return Uma lista de Clientes.
     */
    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    /**
     * Obtém um Cliente pelo seu ID.
     *
     * @param id O ID do Cliente a ser buscado.
     * @return Um Optional contendo o Cliente encontrado, ou vazio se não encontrado.
     */
    @Override
    public Optional<Cliente> buscaPorId(Long id) {
        return clienteRepository.findById(id);
    }

    /**
     * Insere um novo Cliente.
     *
     * @param cliente O Cliente a ser inserido.
     */
    @Override
    public void inserir(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    /**
     * Atualiza um Cliente pelo seu ID.
     *
     * @param id      O ID do Cliente a ser atualizado.
     * @param cliente O Cliente com as informações atualizadas.
     */
    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            clienteRepository.save(cliente);
        }
    }

    /**
     * Deleta um Cliente pelo seu ID.
     *
     * @param id O ID do Cliente a ser deletado.
     */
    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
