package com.techvista.vistajuris.app.service;

import com.techvista.vistajuris.domain.model.ClienteModel;
import com.techvista.vistajuris.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteModel salvar (ClienteModel cliente){
        return clienteRepository.salvar(cliente);
    }

    public Optional<ClienteModel> buscarPorId(Long id){
        return clienteRepository.buscarPorId(id);
    }

    public List<ClienteModel> listarTodos(){
        return clienteRepository.listarTodos();
    }

    public void deletar(Long id){
        clienteRepository.deletar(id);
    }

}
