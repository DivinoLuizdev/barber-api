package com.api.barberdata.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.barberdata.model.Agendamento;
import com.api.barberdata.service.interfaces.GenericService;

/**
 * Controlador para manipulação de entidades Agendamento.
 */
@RestController
@RequestMapping("/api/agendamento")
@CrossOrigin(origins = "*")
public class AgendamentoController {

    @Autowired
    private GenericService<Agendamento> agendamentoService;

    /**
     * Retorna todos os agendamentos.
     *
     * @return Uma lista de agendamentos.
     */
    @GetMapping
    public ResponseEntity<Iterable<Agendamento>> buscarTodos() {
        return ResponseEntity.ok(agendamentoService.buscarTodos());
    }

    /**
     * Retorna um agendamento com base no ID.
     *
     * @param id O ID do agendamento a ser buscado.
     * @return O agendamento correspondente ao ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Agendamento>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(agendamentoService.buscaPorId(id));
    }

    /**
     * Insere um novo agendamento.
     *
     * @param agendamento O agendamento a ser inserido.
     * @return O agendamento inserido.
     */
    @PostMapping
    public ResponseEntity<Agendamento> inserir(@RequestBody Agendamento agendamento) {
        agendamentoService.inserir(agendamento);
        return ResponseEntity.ok(agendamento);
    }

    /**
     * Atualiza um agendamento existente com base no ID.
     *
     * @param id          O ID do agendamento a ser atualizado.
     * @param agendamento O agendamento com as informações atualizadas.
     * @return O agendamento atualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizar(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        agendamentoService.atualizar(id, agendamento);
        return ResponseEntity.ok(agendamento);
    }

    /**
     * Deleta um agendamento com base no ID.
     *
     * @param id O ID do agendamento a ser deletado.
     * @return Resposta vazia (status 204) se a exclusão for bem-sucedida.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        agendamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
