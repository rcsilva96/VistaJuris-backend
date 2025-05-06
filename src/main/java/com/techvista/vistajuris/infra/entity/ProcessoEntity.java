package com.techvista.vistajuris.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "processos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProcessoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroProcesso;

    private enum Status {
        ABERTO,
        FECHADO,
        EM_ANDAMENTO
    }

    @ManyToOne
    private ClienteEntity cliente;

    private String advogadoResponsavel;

    private String escritorioResponsavel;

    @OneToMany(mappedBy = "processo", fetch = FetchType.LAZY)
    private List<AnexoEntity> anexosList;

}
