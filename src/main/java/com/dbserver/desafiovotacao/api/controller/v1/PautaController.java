package com.dbserver.desafiovotacao.api.controller.v1;

import com.dbserver.desafiovotacao.api.assembler.PautaAssembler;
import com.dbserver.desafiovotacao.api.model.PautaModel;
import com.dbserver.desafiovotacao.api.model.PautaModelSemResultado;
import com.dbserver.desafiovotacao.api.model.input.PautaInput;
import com.dbserver.desafiovotacao.domain.model.Pauta;
import com.dbserver.desafiovotacao.domain.repository.PautaRepository;
import com.dbserver.desafiovotacao.domain.service.RegistroPautaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/pautas")
public class PautaController {

    private final PautaAssembler pautaAssembler;
    private final PautaRepository pautaRepository;
    private final RegistroPautaService registroPautaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PautaModelSemResultado cadastrar(@Valid @RequestBody PautaInput pautaInput) {
        var novaPauta = pautaAssembler.toEntity(pautaInput);
        var pautaCadastrada = registroPautaService.salvar(novaPauta);

        return pautaAssembler.toModelSemResultado(pautaCadastrada);
    }

    @GetMapping
    public List<PautaModel> contabilizarVotos() {
        List<Pauta> pautas = pautaRepository.findAll();

        return pautaAssembler.toCollectionModel(pautas, registroPautaService);
    }
}
