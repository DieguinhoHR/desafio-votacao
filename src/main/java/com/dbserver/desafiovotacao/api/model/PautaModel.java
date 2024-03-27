package com.dbserver.desafiovotacao.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PautaModel {

    private String nome;
    private String descricao;
    private LocalDateTime dataInicio;
}
