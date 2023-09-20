package com.api.barberdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.barberdata.model.Fornecedor;
import com.api.barberdata.service.interfaces.GenericService;

/**
 * Controlador responsável por lidar com operações relacionadas a Fornecedores.
 */
@RestController
@RequestMapping("/api/fornecedores")
@CrossOrigin(origins = "*")
public class FornecedorController {

    @Autowired
    private GenericService<Fornecedor> fornecedorService;

    /**
     * Endpoint para buscar todos os Fornecedores.
     *
     * @return ResponseEntity contendo a lista de Fornecedores.
     */
    @GetMapping
    public ResponseEntity<Iterable<Fornecedor>> buscarTodos() {
        return ResponseEntity.ok(fornecedorService.buscarTodos());
    }

    /**
     * Endpoint para buscar um Fornecedor pelo ID.
     *
     * @param id O ID do Fornecedor a ser buscado.
     * @return ResponseEntity contendo o Fornecedor encontrado ou status HTTP 404 se não encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(fornecedorService.buscaPorId(id).orElse(null));
    }

    /**
     * Endpoint para inserir um novo Fornecedor.
     *
     * @param fornecedor O Fornecedor a ser inserido.
     * @return ResponseEntity contendo o Fornecedor recém-inserido.
     */
    @PostMapping
    public ResponseEntity<Fornecedor> inserir(@RequestBody Fornecedor fornecedor) {
        fornecedorService.inserir(fornecedor);
        return ResponseEntity.ok(fornecedor);
    }

    /**
     * Endpoint para atualizar um Fornecedor existente pelo ID.
     *
     * @param id         O ID do Fornecedor a ser atualizado.
     * @param fornecedor Os dados atualizados do Fornecedor.
     * @return ResponseEntity contendo o Fornecedor atualizado ou status HTTP 404 se não encontrado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizar(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        fornecedorService.atualizar(id, fornecedor);
        return ResponseEntity.ok(fornecedor);
    }

    /**
     * Endpoint para deletar um Fornecedor pelo ID.
     *
     * @param id O ID do Fornecedor a ser deletado.
     * @return ResponseEntity indicando o sucesso da operação.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        fornecedorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
