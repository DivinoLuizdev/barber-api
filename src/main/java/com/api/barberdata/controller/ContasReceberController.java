package com.api.barberdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.barberdata.domain.ContasReceber;
import com.api.barberdata.service.interfaces.GenericService;

/**
 * Controlador responsável por lidar com operações relacionadas a ContasReceber.
 */
@RestController
@RequestMapping("/api/contasreceber")
@CrossOrigin(origins = "*")
public class ContasReceberController {

    @Autowired
    private GenericService<ContasReceber> contasReceberService;

    /**
     * Endpoint para buscar todas as Contas a Receber.
     *
     * @return ResponseEntity contendo a lista de Contas a Receber.
     */
    @GetMapping
    public ResponseEntity<Iterable<ContasReceber>> buscarTodos() {
        return ResponseEntity.ok(contasReceberService.buscarTodos());
    }

    /**
     * Endpoint para buscar uma Conta a Receber pelo ID.
     *
     * @param id O ID da Conta a Receber a ser buscada.
     * @return ResponseEntity contendo a Conta a Receber encontrada ou status HTTP 404 se não encontrada.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ContasReceber> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(contasReceberService.buscaPorId(id).orElse(null));
    }

    /**
     * Endpoint para inserir uma nova Conta a Receber.
     *
     * @param contasReceber A Conta a Receber a ser inserida.
     * @return ResponseEntity contendo a Conta a Receber recém-inserida.
     */
    @PostMapping
    public ResponseEntity<ContasReceber> inserir(@RequestBody ContasReceber contasReceber) {
        contasReceberService.inserir(contasReceber);
        return ResponseEntity.ok(contasReceber);
    }

    /**
     * Endpoint para atualizar uma Conta a Receber existente pelo ID.
     *
     * @param id            O ID da Conta a Receber a ser atualizada.
     * @param contasReceber Os dados atualizados da Conta a Receber.
     * @return ResponseEntity contendo a Conta a Receber atualizada ou status HTTP 404 se não encontrada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ContasReceber> atualizar(@PathVariable Long id, @RequestBody ContasReceber contasReceber) {
        contasReceberService.atualizar(id, contasReceber);
        return ResponseEntity.ok(contasReceber);
    }

    /**
     * Endpoint para deletar uma Conta a Receber pelo ID.
     *
     * @param id O ID da Conta a Receber a ser deletada.
     * @return ResponseEntity indicando o sucesso da operação.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        contasReceberService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
