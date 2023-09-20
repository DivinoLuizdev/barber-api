package com.api.barberdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.barberdata.model.OrdemServicos;
import com.api.barberdata.service.interfaces.GenericService;

/**
 * Controlador responsável por lidar com operações relacionadas a Ordens de Serviço.
 */
@RestController
@RequestMapping("/api/ordens-servico")
@CrossOrigin(origins = "*")
public class OrdemServicosController {

    @Autowired
    private GenericService<OrdemServicos> ordemServicosService;

    /**
     * Endpoint para buscar todas as Ordens de Serviço.
     *
     * @return ResponseEntity contendo a lista de Ordens de Serviço.
     */
    @GetMapping
    public ResponseEntity<Iterable<OrdemServicos>> buscarTodos() {
        return ResponseEntity.ok(ordemServicosService.buscarTodos());
    }

    /**
     * Endpoint para buscar uma Ordem de Serviço pelo ID.
     *
     * @param id O ID da Ordem de Serviço a ser buscada.
     * @return ResponseEntity contendo a Ordem de Serviço encontrada ou status HTTP 404 se não encontrada.
     */
    @GetMapping("/{id}")
    public ResponseEntity<OrdemServicos> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ordemServicosService.buscaPorId(id).orElse(null));
    }

    /**
     * Endpoint para inserir uma nova Ordem de Serviço.
     *
     * @param ordemServicos A Ordem de Serviço a ser inserida.
     * @return ResponseEntity contendo a Ordem de Serviço recém-inserida.
     */
    @PostMapping
    public ResponseEntity<OrdemServicos> inserir(@RequestBody OrdemServicos ordemServicos) {
        ordemServicosService.inserir(ordemServicos);
        return ResponseEntity.ok(ordemServicos);
    }

    /**
     * Endpoint para atualizar uma Ordem de Serviço existente pelo ID.
     *
     * @param id            O ID da Ordem de Serviço a ser atualizada.
     * @param ordemServicos Os dados atualizados da Ordem de Serviço.
     * @return ResponseEntity contendo a Ordem de Serviço atualizada ou status HTTP 404 se não encontrada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<OrdemServicos> atualizar(@PathVariable Long id, @RequestBody OrdemServicos ordemServicos) {
        ordemServicosService.atualizar(id, ordemServicos);
        return ResponseEntity.ok(ordemServicos);
    }

    /**
     * Endpoint para deletar uma Ordem de Serviço pelo ID.
     *
     * @param id O ID da Ordem de Serviço a ser deletada.
     * @return ResponseEntity indicando o sucesso da operação.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ordemServicosService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
