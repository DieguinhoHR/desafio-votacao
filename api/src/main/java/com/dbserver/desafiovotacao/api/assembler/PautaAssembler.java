package com.dbserver.desafiovotacao.api.assembler;

import com.dbserver.desafiovotacao.api.model.PautaModel;
import com.dbserver.desafiovotacao.api.model.PautaModelSemResultado;
import com.dbserver.desafiovotacao.api.model.input.PautaInput;
import com.dbserver.desafiovotacao.domain.model.Pauta;
import com.dbserver.desafiovotacao.domain.service.RegistroPautaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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

    public PautaModelSemResultado toModelSemResultado(Pauta pauta) {
        return modelMapper.map(pauta, PautaModelSemResultado.class);
    }

    public PautaModel toModelResultadoVotos(Pauta pauta, Map<String, Long> resultadoVotos) {
        var pautaModel = modelMapper.map(pauta, PautaModel.class);
        pautaModel.setResultado(resultadoVotos);

        return pautaModel;
    }

    public List<PautaModel> toCollectionModel(List<Pauta> pautas, RegistroPautaService registroPautaService) {
        return pautas.stream()
                .map(pauta -> toModelResultadoVotos(pauta, registroPautaService.exibirResultadoVotacao(pauta)))
                .toList();
    }
}
