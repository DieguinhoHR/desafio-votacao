package com.dbserver.desafiovotacao.api.controller.v1;

import com.dbserver.desafiovotacao.domain.service.RegistroSessaoVotacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/sessoes/{pautaId}/sessoes-votacoes")
public class SessaoVotacaoController {

    private final RegistroSessaoVotacaoService sessaoVotacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarSessaoVotacao(@PathVariable("pautaId") Long pautaId) {
        sessaoVotacaoService.iniciarSessaoVotacao(pautaId, LocalDateTime.now()
                .plusSeconds(sessaoVotacaoService.getTempoSessaoPadrao()));
    }
}
