package com.api.barberdata.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.barberdata.domain.Servicos;
import com.api.barberdata.service.interfaces.GenericService;

/**
 * Controlador para manipulação de entidades Serviços.
 */
@RestController
@RequestMapping("/api/servicos")
@CrossOrigin(origins = "*")
public class ServicosController {

    @Autowired
    private GenericService<Servicos> servicosService;

    /**
     * Retorna todos os serviços.
     *
     * @return Uma lista de serviços.
     */
    @GetMapping
    public ResponseEntity<Iterable<Servicos>> buscarTodos() {
        return ResponseEntity.ok(servicosService.buscarTodos());
    }

    /**
     * Retorna um serviço com base no ID.
     *
     * @param id O ID do serviço a ser buscado.
     * @return O serviço correspondente ao ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Servicos>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servicosService.buscaPorId(id));
    }

    /**
     * Insere um novo serviço.
     *
     * @param servicos O serviço a ser inserido.
     * @return O serviço inserido.
     */
    @PostMapping
    public ResponseEntity<Servicos> inserir(@RequestBody Servicos servicos) {
        servicosService.inserir(servicos);
        return ResponseEntity.ok(servicos);
    }

    /**
     * Atualiza um serviço existente com base no ID.
     *
     * @param id       O ID do serviço a ser atualizado.
     * @param servicos O serviço com as informações atualizadas.
     * @return O serviço atualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Servicos> atualizar(@PathVariable Long id, @RequestBody Servicos servicos) {
        servicosService.atualizar(id, servicos);
        return ResponseEntity.ok(servicos);
    }

    /**
     * Deleta um serviço com base no ID.
     *
     * @param id O ID do serviço a ser deletado.
     * @return Resposta vazia (status 204) se a exclusão for bem-sucedida.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        servicosService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
