package com.dbserver.desafiovotacao.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SessaoVotacaoModel {

    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
}
