package com.techvista.vistajuris.app.usecase;

import com.techvista.vistajuris.domain.model.ClienteModel;

import java.util.List;

public interface ClienteUseCase {

    ClienteModel cadastrar(ClienteModel cliente);
    List<ClienteModel> listar();

}
