package com.dbserver.desafiovotacao.api.controller.v1;

import com.dbserver.desafiovotacao.api.assembler.SessaoVotoAssembler;
import com.dbserver.desafiovotacao.api.model.PautaModel;
import com.dbserver.desafiovotacao.api.model.SessaoVotacaoModel;
import com.dbserver.desafiovotacao.domain.model.Pauta;
import com.dbserver.desafiovotacao.domain.model.SessaoVotacao;
import com.dbserver.desafiovotacao.domain.model.Voto;
import com.dbserver.desafiovotacao.domain.repository.SessaoVotacaoRepository;
import com.dbserver.desafiovotacao.domain.service.RegistroSessaoVotacaoService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/sessoes")
public class SessaoVotacaoController {

    private static final Logger logger = LoggerFactory.getLogger(SessaoVotacaoController.class);

    private final RegistroSessaoVotacaoService sessaoVotacaoService;
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final SessaoVotoAssembler sessaoVotoAssembler;

    @GetMapping
    public List<SessaoVotacaoModel> sessaoVotos() {
        logger.info("Listando votos inicializados");
        List<SessaoVotacao> sessaoVotos = sessaoVotacaoRepository.findAll();

        return sessaoVotoAssembler.toCollectionModel(sessaoVotos);
    }

    @PostMapping(value = "/{pautaId}/sessoes-votacoes")
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarSessaoVotacao(@PathVariable("pautaId") Long pautaId) {
        sessaoVotacaoService.iniciarSessaoVotacao(pautaId, LocalDateTime.now()
                .plusSeconds(sessaoVotacaoService.getTempoSessaoPadrao()));

        logger.info("Sessão de votação iniciada, o tempo irá expirar em -> " +
                sessaoVotacaoService.getTempoSessaoPadrao() + " segundos.");

    }
}
