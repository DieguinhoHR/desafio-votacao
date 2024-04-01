package com.dbserver.desafiovotacao.api.assembler;

import com.dbserver.desafiovotacao.api.model.SessaoVotacaoModel;
import com.dbserver.desafiovotacao.domain.model.SessaoVotacao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class SessaoVotoAssembler {

    private final ModelMapper modelMapper;

    public SessaoVotacaoModel toModel(SessaoVotacao sessaoVotacao) {
        return modelMapper.map(sessaoVotacao, SessaoVotacaoModel.class);
    }

    public List<SessaoVotacaoModel> toCollectionModel(List<SessaoVotacao> votacoes) {
        return votacoes.stream()
                .map(this::toModel)
                .toList();
    }
}
