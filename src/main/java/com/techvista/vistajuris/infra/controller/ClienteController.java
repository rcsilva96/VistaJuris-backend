package com.techvista.vistajuris.infra.controller;

import com.techvista.vistajuris.domain.model.ClienteModel;
import com.techvista.vistajuris.app.usecase.ClienteUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    public ClienteController(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    @PostMapping
    public ResponseEntity<ClienteModel> salvar(@RequestBody ClienteModel cliente){
        return ResponseEntity.ok(clienteUseCase.salvar(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> listarTodos(){
        return ResponseEntity.ok(clienteUseCase.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> buscarPorId(@PathVariable Long id){
        return clienteUseCase.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
