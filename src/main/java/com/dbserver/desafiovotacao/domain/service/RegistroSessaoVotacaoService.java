package com.dbserver.desafiovotacao.domain.service;

import com.dbserver.desafiovotacao.domain.exception.EntidadeNaoEncontradaException;
import com.dbserver.desafiovotacao.domain.exception.SessaoJaCadastradaException;
import com.dbserver.desafiovotacao.domain.model.Pauta;
import com.dbserver.desafiovotacao.domain.model.SessaoVotacao;
import com.dbserver.desafiovotacao.domain.repository.PautaRepository;
import com.dbserver.desafiovotacao.domain.repository.SessaoVotacaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RegistroSessaoVotacaoService {

    @Value("${tempo.sessao.votacao.em.segundos}")
    private Integer tempoSessaoPadrao;

    private final RegistroPautaService registroPautaService;
    private final SessaoVotacaoRepository sessaoVotacaoRepository;

    @Transactional
    public void iniciarSessaoVotacao(Long pautaId, LocalDateTime dataFimVotacao) {
        var pauta = registroPautaService.buscarPorId(pautaId);

        var sessaoVotacaoEncontrada = sessaoVotacaoRepository.findByPauta(pauta);

        if (Objects.requireNonNull(sessaoVotacaoEncontrada).isPresent()){
            throw new SessaoJaCadastradaException("Sessão já cadastrada no sistema");
        }
        sessaoVotacaoRepository.save(getSessaoVotacaoBuilder(pauta, dataFimVotacao));
    }

    private SessaoVotacao getSessaoVotacaoBuilder(Pauta pauta, LocalDateTime dataFimVotacao) {
        return SessaoVotacao.builder()
                .dataInicio(LocalDateTime.now())
                .dataFim(getDataFinalVotacao(dataFimVotacao))
                .pauta(pauta)
                .build();
    }

    private LocalDateTime getDataFinalVotacao(LocalDateTime dataFechamento) {
        if (dataFechamento == null) {
            return LocalDateTime.now().plusSeconds(tempoSessaoPadrao);
        }
        return dataFechamento;
    }

    public Integer getTempoSessaoPadrao() {
        return tempoSessaoPadrao;
    }
}
