package com.techvista.vistajuris.app.usecase;

import com.techvista.vistajuris.domain.model.ClienteModel;

import java.util.List;
import java.util.Optional;

public interface ClienteUseCase {

    ClienteModel salvar(ClienteModel cliente);
    List<ClienteModel> listarTodos();
    Optional<ClienteModel> buscarPorId(Long id);
    void deletar(Long id);

}
