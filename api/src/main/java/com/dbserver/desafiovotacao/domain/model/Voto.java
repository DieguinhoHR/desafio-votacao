package com.dbserver.desafiovotacao.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Voto {

    @Id
    private String cpfEleitor;

    @Enumerated(EnumType.STRING)
    private StatusVoto statusVoto;
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "sessao_votacao_id")
    private SessaoVotacao sessaoVotacao;
}
