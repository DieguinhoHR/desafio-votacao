package com.dbserver.desafiovotacao.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class SessaoVoto {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    @OneToOne
    @JoinColumn(name = "id_pauta")
    private Pauta pauta;

}
