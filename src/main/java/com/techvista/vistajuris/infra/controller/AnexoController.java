package com.techvista.vistajuris.infra.controller;


import com.techvista.vistajuris.app.service.AnexoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/anexos")
public class AnexoController {

    private final AnexoService anexoService;

    public AnexoController(AnexoService anexoService) {
        this.anexoService = anexoService;
    }

    @PostMapping("/upload/{processoId}")
    public ResponseEntity<String> uploadAnexo(
            @PathVariable Long processoId,
            @RequestParam("file") MultipartFile file) {
        try {
            anexoService.salvarAnexo(processoId, file);
            return ResponseEntity.ok("Arquivo enviado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao enviar o arquivo.");
        }
    }
}


