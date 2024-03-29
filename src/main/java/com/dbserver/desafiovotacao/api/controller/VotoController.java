package com.dbserver.desafiovotacao.api.controller;

import com.dbserver.desafiovotacao.api.assembler.VotoAssembler;
import com.dbserver.desafiovotacao.api.model.VotoModel;
import com.dbserver.desafiovotacao.api.model.input.VotoInput;
import com.dbserver.desafiovotacao.domain.service.VotoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/pautas/{pautaId}/votos")
public class VotoController {

    private final VotoAssembler votoAssembler;
    private final VotoService votoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VotoModel votar(@PathVariable("pautaId") Long pautaId,
                           @Valid @RequestBody VotoInput votarInput) {
        var novoVoto = votoAssembler.toEntity(votarInput);
        var votoCadastrado = votoService.votar(pautaId, novoVoto);

        return votoAssembler.toModel(votoCadastrado);
    }
}
