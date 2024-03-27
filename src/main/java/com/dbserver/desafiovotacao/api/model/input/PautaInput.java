package com.dbserver.desafiovotacao.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class PautaInput {

    @NotBlank
    @Size(max = 150)
    private String nome;
    private String descricao;

    @NotBlank
    private OffsetDateTime dataInicio;
}
