package com.techvista.vistajuris.domain.repository;

import com.techvista.vistajuris.infra.entity.AnexoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexoRepository extends JpaRepository<AnexoEntity, Long> {
    AnexoEntity save(AnexoEntity anexoEntity);
}