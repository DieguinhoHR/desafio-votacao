package com.dbserver.desafiovotacao.api.model;

import com.dbserver.desafiovotacao.domain.model.StatusVoto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class VotoModel {

    private StatusVoto statusVoto;
    private LocalDateTime dataHora;
}
