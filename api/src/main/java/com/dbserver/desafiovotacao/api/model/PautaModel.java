package com.dbserver.desafiovotacao.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class PautaModel {

    private String id;
    private String nome;
    private Map<String, Long> resultado;
}
