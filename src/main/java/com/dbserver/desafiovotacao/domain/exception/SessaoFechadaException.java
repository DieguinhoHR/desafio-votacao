package com.dbserver.desafiovotacao.domain.exception;

public class SessaoFechadaException extends NegocioException {

    public SessaoFechadaException(String message) {
        super(message);
    }
}