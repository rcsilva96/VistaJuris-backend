package com.techvista.vistajuris.infra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class AnexoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeArquivo;

    private String caminhoArquivo;

    @ManyToOne
    @JoinColumn(name = "processo_id")
    private ProcessoEntity processo;
}
