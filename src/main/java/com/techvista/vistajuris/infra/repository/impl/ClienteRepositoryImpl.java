package com.techvista.vistajuris.infra.repository.impl;

import com.techvista.vistajuris.domain.model.ClienteModel;
import com.techvista.vistajuris.domain.repository.ClienteRepository;
import com.techvista.vistajuris.infra.entity.ClienteEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
    
    private final ClienteRepository clienteRepository;
    
    public ClienteRepositoryImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    @Override
    public ClienteModel salvar(ClienteModel cliente){
        
        clienteEntity entity = toEntity(cliente);
        return toDomain(clienteRepository.save(entity));
        
    }

    @Override
    public Optional<ClienteModel> buscarPorId(Long id) {

        return clienteRepository.findAll().stream().map(this::toDomain).collect(collectors.toList());

    }

    @Override
    public void deletar(Long id) {

        clienteRepository.deleteById(id);

    }

    // Conversores
    private Cliente toDomain(ClienteEntity entity) {
        Cliente cliente = new Cliente();
        cliente.setId(entity.getId());
        cliente.setNome(entity.getNome());
        cliente.setEmail(entity.getEmail());
        cliente.setTelefone(entity.getTelefone());
        cliente.setDataCadastro(entity.getDataCadastro());
        return cliente;
    }

    private ClienteEntity toEntity(Cliente cliente) {
        ClienteEntity entity = new ClienteEntity();
        entity.setId(cliente.getId());
        entity.setNome(cliente.getNome());
        entity.setEmail(cliente.getEmail());
        entity.setTelefone(cliente.getTelefone());
        entity.setDataCadastro(cliente.getDataCadastro());
        return entity;
    }
    
}
