package com.dbserver.desafiovotacao.api.assembler;

import com.dbserver.desafiovotacao.api.model.PautaModel;
import com.dbserver.desafiovotacao.api.model.input.PautaInput;
import com.dbserver.desafiovotacao.domain.model.Pauta;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PautaAssembler {

    private final ModelMapper modelMapper;

    public Pauta toEntity(PautaInput pautaInput) {
        return modelMapper.map(pautaInput, Pauta.class);
    }

    public PautaModel toModel(Pauta pauta) {
        return modelMapper.map(pauta, PautaModel.class);
    }
}
