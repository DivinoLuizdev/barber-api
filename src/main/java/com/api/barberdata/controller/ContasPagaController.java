package com.api.barberdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.barberdata.model.ContasPaga;
import com.api.barberdata.service.interfaces.GenericService;

/**
 * Controlador responsável por lidar com operações relacionadas a ContasPaga.
 */
@RestController
@RequestMapping("/api/contaspaga")
@CrossOrigin(origins = "*")
public class ContasPagaController {

    @Autowired
    private GenericService<ContasPaga> contasPagaService;

    /**
     * Endpoint para buscar todas as ContasPagas.
     * 
     * @return ResponseEntity contendo a lista de ContasPagas.
     */
    @GetMapping
    public ResponseEntity<Iterable<ContasPaga>> buscarTodos() {
        return ResponseEntity.ok(contasPagaService.buscarTodos());
    }

    /**
     * Endpoint para buscar uma ContasPaga pelo ID.
     * 
     * @param id O ID da ContasPaga a ser buscada.
     * @return ResponseEntity contendo a ContasPaga encontrada ou status HTTP 404 se não encontrada.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ContasPaga> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(contasPagaService.buscaPorId(id).orElse(null));
    }

    /**
     * Endpoint para inserir uma nova ContasPaga.
     * 
     * @param contasPaga A ContasPaga a ser inserida.
     * @return ResponseEntity contendo a ContasPaga recém-inserida.
     */
    @PostMapping
    public ResponseEntity<ContasPaga> inserir(@RequestBody ContasPaga contasPaga) {
        contasPagaService.inserir(contasPaga);
        return ResponseEntity.ok(contasPaga);
    }

    /**
     * Endpoint para atualizar uma ContasPaga existente pelo ID.
     * 
     * @param id         O ID da ContasPaga a ser atualizada.
     * @param contasPaga Os dados atualizados da ContasPaga.
     * @return ResponseEntity contendo a ContasPaga atualizada ou status HTTP 404 se não encontrada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ContasPaga> atualizar(@PathVariable Long id, @RequestBody ContasPaga contasPaga) {
        contasPagaService.atualizar(id, contasPaga);
        return ResponseEntity.ok(contasPaga);
    }

    /**
     * Endpoint para deletar uma ContasPaga pelo ID.
     * 
     * @param id O ID da ContasPaga a ser deletada.
     * @return ResponseEntity indicando o sucesso da operação.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        contasPagaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
