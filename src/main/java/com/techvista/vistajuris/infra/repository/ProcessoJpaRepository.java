package com.techvista.vistajuris.infra.repository;

import com.techvista.vistajuris.domain.repository.ProcessoRepository;
import com.techvista.vistajuris.infra.entity.ProcessoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoJpaRepository extends JpaRepository<ProcessoEntity, Long>, ProcessoRepository {
}

