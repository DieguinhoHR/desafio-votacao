package com.dbserver.desafiovotacao.api.model.input;

import com.dbserver.desafiovotacao.domain.model.SessaoVotacao;
import com.dbserver.desafiovotacao.domain.model.StatusVoto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotoInput {

    //@NotNull(message = "CPF obrigatório.")
    private String cpfEleitor;
    private StatusVoto statusVoto;
    private SessaoVotacaoIdInput sessaoVotacaoIdInput;
}
