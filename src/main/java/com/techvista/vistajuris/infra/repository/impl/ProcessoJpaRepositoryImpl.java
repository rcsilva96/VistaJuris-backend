//package com.techvista.vistajuris.infra.repository.impl;
//
//import com.techvista.vistajuris.domain.repository.ProcessoRepository;
//import com.techvista.vistajuris.infra.entity.ProcessoEntity;
//import com.techvista.vistajuris.infra.repository.ProcessoJpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public class ProcessoJpaRepositoryImpl implements ProcessoRepository {
//
//    private final ProcessoJpaRepository repository;
//
//    public ProcessoJpaRepositoryImpl(ProcessoJpaRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public Optional<ProcessoEntity> findById(Long id) {
//        return repository.findById(id);
//    }
//
//    @Override
//    public ProcessoEntity save(ProcessoEntity processo) {
//        return repository.save(processo);
//    }
//}
//
