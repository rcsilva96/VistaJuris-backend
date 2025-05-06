package com.techvista.vistajuris.infra.controller;

import com.techvista.vistajuris.app.service.ProcessoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/processos")
@RequiredArgsConstructor
public class ProcessoController {

    private final ProcessoService processoService;

    @PostMapping(value = "/{processoId}/anexos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadAnexo(
            @PathVariable Long processoId,
            @RequestPart("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Arquivo não pode estar vazio");
            }
            processoService.salvarAnexo(processoId, file);
            return ResponseEntity.ok("Arquivo enviado com sucesso!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar arquivo: " + e.getMessage());
        }
    }
}