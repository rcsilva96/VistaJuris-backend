package com.techvista.vistajuris.app.service;

import com.techvista.vistajuris.domain.repository.AnexoRepository;
import com.techvista.vistajuris.domain.repository.ProcessoRepository;
import com.techvista.vistajuris.infra.entity.AnexoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class ProcessoService {

    private final ProcessoRepository processoRepository;
    private final AnexoRepository anexoRepository;

    public ProcessoService(ProcessoRepository processoRepository,
                           AnexoRepository anexoRepository) {
        this.processoRepository = processoRepository;
        this.anexoRepository = anexoRepository;
    }

    public void salvarAnexo(Long processoId, MultipartFile file) throws IOException {
        var processo = processoRepository.findById(processoId)
                .orElseThrow(() -> new RuntimeException("Processo não encontrado"));

        // Cria a pasta se não existir
        Path uploadDir = Paths.get("uploads");
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        // Nome do arquivo salvo
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = uploadDir.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Cria o anexo e salva
        AnexoEntity anexo = new AnexoEntity();
        anexo.setNomeArquivo(file.getOriginalFilename());
        anexo.setCaminhoArquivo(filePath.toString());
        anexo.setProcesso(processo);
        anexoRepository.save(anexo);

        processo.getAnexosList().add(anexo);
        processoRepository.save(processo); // atualiza o processo
    }
}

