package com.dbserver.desafiovotacao.api.model.input;

import com.dbserver.desafiovotacao.domain.model.StatusVoto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class VotoInput {

    @NotNull(message = "CPF obrigatório")
    private String cpfEleitor;

    @NotNull(message = "Mensagem de voto é obrigatório: SIM/NAO")
    private StatusVoto statusVoto;
    private SessaoVotacaoIdInput sessaoVotacaoIdInput;
}
