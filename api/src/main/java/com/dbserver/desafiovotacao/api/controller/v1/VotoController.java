package com.dbserver.desafiovotacao.api.controller.v1;

import com.dbserver.desafiovotacao.api.assembler.VotoAssembler;
import com.dbserver.desafiovotacao.api.model.VotoModel;
import com.dbserver.desafiovotacao.api.model.input.VotoInput;
import com.dbserver.desafiovotacao.domain.service.RegistroVotoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/pautas/{pautaId}/votos")
public class VotoController {

    private static final Logger logger = LoggerFactory.getLogger(VotoController.class);

    private final VotoAssembler votoAssembler;
    private final RegistroVotoService votoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VotoModel votar(@PathVariable("pautaId") Long pautaId,
                           @Valid @RequestBody VotoInput votarInput) {
        var novoVoto = votoAssembler.toEntity(votarInput);
        var votoCadastrado = votoService.votar(pautaId, novoVoto);

        logger.info("Voto realizado com sucesso!");

        return votoAssembler.toModel(votoCadastrado);
    }
}
