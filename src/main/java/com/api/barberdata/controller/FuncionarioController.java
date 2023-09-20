package com.api.barberdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.barberdata.model.Funcionario;
import com.api.barberdata.service.interfaces.GenericService;

/**
 * Controlador responsável por lidar com operações relacionadas a Funcionários.
 */
@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin(origins = "*")
public class FuncionarioController {

    @Autowired
    private GenericService<Funcionario> funcionarioService;

    /**
     * Endpoint para buscar todos os Funcionários.
     *
     * @return ResponseEntity contendo a lista de Funcionários.
     */
    @GetMapping
    public ResponseEntity<Iterable<Funcionario>> buscarTodos() {
        return ResponseEntity.ok(funcionarioService.buscarTodos());
    }

    /**
     * Endpoint para buscar um Funcionário pelo ID.
     *
     * @param id O ID do Funcionário a ser buscado.
     * @return ResponseEntity contendo o Funcionário encontrado ou status HTTP 404 se não encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.buscaPorId(id).orElse(null));
    }

    /**
     * Endpoint para inserir um novo Funcionário.
     *
     * @param funcionario O Funcionário a ser inserido.
     * @return ResponseEntity contendo o Funcionário recém-inserido.
     */
    @PostMapping
    public ResponseEntity<Funcionario> inserir(@RequestBody Funcionario funcionario) {
        funcionarioService.inserir(funcionario);
        return ResponseEntity.ok(funcionario);
    }

    /**
     * Endpoint para atualizar um Funcionário existente pelo ID.
     *
     * @param id          O ID do Funcionário a ser atualizado.
     * @param funcionario Os dados atualizados do Funcionário.
     * @return ResponseEntity contendo o Funcionário atualizado ou status HTTP 404 se não encontrado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        funcionarioService.atualizar(id, funcionario);
        return ResponseEntity.ok(funcionario);
    }

    /**
     * Endpoint para deletar um Funcionário pelo ID.
     *
     * @param id O ID do Funcionário a ser deletado.
     * @return ResponseEntity indicando o sucesso da operação.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
