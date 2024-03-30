package com.dbserver.desafiovotacao.api.assembler;

import com.dbserver.desafiovotacao.api.model.VotoModel;
import com.dbserver.desafiovotacao.api.model.input.VotoInput;
import com.dbserver.desafiovotacao.domain.model.Voto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class VotoAssembler {

    private final ModelMapper modelMapper;

    public Voto toEntity(VotoInput votoInput) {
        return modelMapper.map(votoInput, Voto.class);
    }

    public VotoModel toModel(Voto voto) {
        return modelMapper.map(voto, VotoModel.class);
    }
}
