package com.dbserver.desafiovotacao.api.controller;

import com.dbserver.desafiovotacao.domain.model.SessaoVotacao;
import com.dbserver.desafiovotacao.domain.service.RegistroSessaoVotacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@RestController
@RequestMapping("/sessoes/{pautaId}/sessoes-votacoes")
public class SessaoVotacaoController {

    private final RegistroSessaoVotacaoService sessaoVotacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarSessaoVotacao(@PathVariable("pautaId") Long pautaId) {
        sessaoVotacaoService.iniciarSessaoVotacao(pautaId, LocalDateTime.now()
                .plusSeconds(sessaoVotacaoService.getTempoSessaoPadrao()));
    }
}
