package com.techvista.vistajuris.infra.repository;

import com.techvista.vistajuris.infra.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {

}
