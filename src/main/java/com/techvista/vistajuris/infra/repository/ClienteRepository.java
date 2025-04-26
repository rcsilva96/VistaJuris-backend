package com.techvista.vistajuris.infra.repository;

import com.techvista.vistajuris.infra.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
