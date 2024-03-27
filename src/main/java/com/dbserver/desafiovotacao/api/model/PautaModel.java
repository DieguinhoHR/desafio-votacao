package com.dbserver.desafiovotacao.api.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
public class PautaModel {

    private String nome;
    private String descricao;
    private OffsetDateTime dataInicio;
}
