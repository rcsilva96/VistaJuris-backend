package com.techvista.vistajuris.domain.repository;

import com.techvista.vistajuris.infra.entity.ProcessoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProcessoRepository {

    Optional<ProcessoEntity> findById(Long id);
    ProcessoEntity save(ProcessoEntity processo);

}
