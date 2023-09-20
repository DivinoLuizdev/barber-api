package com.api.barberdata.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.barberdata.model.Cliente;
import com.api.barberdata.service.interfaces.GenericService;

/**
 * Controlador para manipulação de entidades Cliente.
 */
@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private GenericService<Cliente> clienteService;

    /**
     * Retorna todos os clientes.
     *
     * @return Uma lista de clientes.
     */
    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    /**
     * Retorna um cliente com base no ID.
     *
     * @param id O ID do cliente a ser buscado.
     * @return O cliente correspondente ao ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscaPorId(id));
    }

    /**
     * Insere um novo cliente.
     *
     * @param cliente O cliente a ser inserido.
     * @return O cliente inserido.
     */
    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    /**
     * Atualiza um cliente existente com base no ID.
     *
     * @param id      O ID do cliente a ser atualizado.
     * @param cliente O cliente com as informações atualizadas.
     * @return O cliente atualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    /**
     * Deleta um cliente com base no ID.
     *
     * @param id O ID do cliente a ser deletado.
     * @return Resposta vazia (status 204) se a exclusão for bem-sucedida.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
