package com.api.barberdata.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.barberdata.model.Funcionario;
import com.api.barberdata.repository.FuncionarioRepository;
import com.api.barberdata.service.interfaces.GenericService;
/**
 * Implementação da interface GenericService para Funcionários.
 * Esta classe fornece operações CRUD (Create, Read, Update, Delete) para Funcionários.
 * Ela é responsável por interagir com o repositório de Funcionários e realizar as operações necessárias.
 */
@Service
public class FuncionarioServiceImp implements GenericService<Funcionario> {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    /**
     * Obtém todos os Funcionários.
     *
     * @return Uma lista de Funcionários.
     */
    @Override
    public Iterable<Funcionario> buscarTodos() {
        return funcionarioRepository.findAll();
    }

    /**
     * Obtém um Funcionário pelo seu ID.
     *
     * @param id O ID do Funcionário a ser buscado.
     * @return Um Optional contendo o Funcionário encontrado, ou vazio se não encontrado.
     */
    @Override
    public Optional<Funcionario> buscaPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    /**
     * Insere um novo Funcionário.
     *
     * @param funcionario O Funcionário a ser inserido.
     */
    @Override
    public void inserir(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    /**
     * Atualiza um Funcionário pelo seu ID.
     *
     * @param id          O ID do Funcionário a ser atualizado.
     * @param funcionario O Funcionário com as informações atualizadas.
     */
    @Override
    public void atualizar(Long id, Funcionario funcionario) {
        Optional<Funcionario> funcionarioBd = funcionarioRepository.findById(id);
        if (funcionarioBd.isPresent()) {
            funcionarioRepository.save(funcionario);
        }
    }

    /**
     * Deleta um Funcionário pelo seu ID.
     *
     * @param id O ID do Funcionário a ser deletado.
     */
    @Override
    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
