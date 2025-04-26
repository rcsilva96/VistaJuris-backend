package com.techvista.vistajuris.infra.repository.impl;

import com.techvista.vistajuris.domain.model.ClienteModel;
import com.techvista.vistajuris.domain.repository.ClienteRepository;
import com.techvista.vistajuris.infra.entity.ClienteEntity;
import com.techvista.vistajuris.infra.repository.ClienteJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClienteJpaRepository clienteJpaRepository;

    public ClienteRepositoryImpl(ClienteJpaRepository clienteJpaRepository) {
        this.clienteJpaRepository = clienteJpaRepository;
    }

    @Override
    public ClienteModel salvar(ClienteModel cliente) {
        ClienteEntity entity = toEntity(cliente);
        return toDomain(clienteJpaRepository.save(entity));
    }

    @Override
    public Optional<ClienteModel> buscarPorId(Long id) {
        return clienteJpaRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<ClienteModel> listarTodos() {
        return clienteJpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(Long id){
        clienteJpaRepository.deleteById(id);
    }

    private ClienteModel toDomain(ClienteEntity entity) {

        if (entity == null) return null;
        return new ClienteModel(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEmail(),
                entity.getTelefone(),
                entity.getDataCadastro()
        );

    }

    private ClienteEntity toEntity(ClienteModel model) {

        if (model == null) return null;
        return new ClienteEntity(
                model.getId(),
                model.getNome(),
                model.getCpf(),
                model.getEmail(),
                model.getTelefone(),
                model.getDataCadastro()
        );
    }

}