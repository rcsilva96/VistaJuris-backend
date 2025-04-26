package com.techvista.vistajuris.domain.repository;

import com.techvista.vistajuris.domain.model.ClienteModel;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {

    ClienteModel salvar(ClienteModel cliente);
    Optional<ClienteModel> buscarPorId(Long id);
    List<ClienteModel> listarTodos();
    void deletar(Long id);

}
