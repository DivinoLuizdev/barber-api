 
package com.api.barberdata.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.barberdata.domain.Servicos;
import com.api.barberdata.repository.ServicosRepository;
import com.api.barberdata.service.interfaces.GenericService;
 /**
 * Implementação da interface GenericService para operações relacionadas a Serviços.
 */
@Service
public class ServicosServiceImp implements GenericService<Servicos> {

    @Autowired
    private ServicosRepository servicosRepository;

    /**
     * Busca todos os serviços.
     *
     * @return Uma lista de todos os serviços.
     */
    @Override
    public Iterable<Servicos> buscarTodos() {
        return servicosRepository.findAll();
    }

    /**
     * Busca um serviço pelo seu ID.
     *
     * @param id O ID do serviço a ser encontrado.
     * @return O serviço correspondente, se encontrado.
     */
    @Override
    public Optional<Servicos> buscaPorId(Long id) {
        return servicosRepository.findById(id);
    }

    /**
     * Insere um novo serviço.
     *
     * @param servicos O serviço a ser inserido.
     */
    @Override
    public void inserir(Servicos servicos) {
        servicosRepository.save(servicos);
    }

    /**
     * Atualiza um serviço existente pelo seu ID.
     *
     * @param id       O ID do serviço a ser atualizado.
     * @param servicos O serviço com os novos dados.
     */
    @Override
    public void atualizar(Long id, Servicos servicos) {
        Optional<Servicos> servicosBd = servicosRepository.findById(id);
        if (servicosBd.isPresent()) {
            servicosRepository.save(servicos);
        }
    }

    /**
     * Deleta um serviço pelo seu ID.
     *
     * @param id O ID do serviço a ser deletado.
     */
    @Override
    public void deletar(Long id) {
        servicosRepository.deleteById(id);
    }
}
