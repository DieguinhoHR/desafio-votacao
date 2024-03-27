package com.dbserver.desafiovotacao.api.controller;

import com.dbserver.desafiovotacao.api.assembler.PautaAssembler;
import com.dbserver.desafiovotacao.api.model.PautaModel;
import com.dbserver.desafiovotacao.api.model.input.PautaInput;
import com.dbserver.desafiovotacao.domain.service.RegistroPautaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pautas")
@AllArgsConstructor
public class PautaController {

    private final PautaAssembler pautaAssembler;
    private final RegistroPautaService registroPautaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PautaModel cadastrar(@Valid @RequestBody PautaInput pautaInput) {
        var novaPauta = pautaAssembler.toEntity(pautaInput);
        var pautaCadastrada = registroPautaService.salvar(novaPauta);

        return pautaAssembler.toModel(pautaCadastrada);
    }
}
