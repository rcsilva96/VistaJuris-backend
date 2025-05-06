package com.techvista.vistajuris.app.service;

import com.techvista.vistajuris.domain.repository.AnexoRepository;
import com.techvista.vistajuris.domain.repository.ProcessoRepository;
import com.techvista.vistajuris.infra.entity.AnexoEntity;
import com.techvista.vistajuris.infra.entity.ProcessoEntity;
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
public class AnexoService {

    private final ProcessoRepository processoRepository;
    private final AnexoRepository anexoRepository;

    public AnexoService(@Lazy ProcessoRepository processoRepository, AnexoRepository anexoRepository) {
        this.processoRepository = processoRepository;
        this.anexoRepository = anexoRepository;
    }

    public void salvarAnexo(Long processoId, MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        Path uploadPath = Paths.get("uploads");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        AnexoEntity anexo = new AnexoEntity();
        anexo.setNomeArquivo(fileName);
        anexo.setCaminhoArquivo("/uploads/" + fileName);

        ProcessoEntity processo = processoRepository.findById(processoId)
                .orElseThrow(() -> new RuntimeException("Processo não encontrado"));

        anexo.setProcesso(processo);
        anexoRepository.save(anexo);
    }
}