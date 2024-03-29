package com.dbserver.desafiovotacao.domain.service;

import com.dbserver.desafiovotacao.api.model.input.VotoInput;
import com.dbserver.desafiovotacao.domain.exception.EntidadeNaoEncontradaException;
import com.dbserver.desafiovotacao.domain.exception.NegocioException;
import com.dbserver.desafiovotacao.domain.exception.SessaoFechadaException;
import com.dbserver.desafiovotacao.domain.model.Pauta;
import com.dbserver.desafiovotacao.domain.model.SessaoVotacao;
import com.dbserver.desafiovotacao.domain.model.Voto;
import com.dbserver.desafiovotacao.domain.repository.PautaRepository;
import com.dbserver.desafiovotacao.domain.repository.SessaoVotacaoRepository;
import com.dbserver.desafiovotacao.domain.repository.VotoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@Service
public class VotoService {

    private final PautaRepository pautaRepository;
    private final VotoRepository votoRepository;
    private final SessaoVotacaoRepository sessaoRepository;

    public Optional<Pauta> getPauta(Long id) {
        return pautaRepository.findById(id);
    }

    private Optional<SessaoVotacao> getSessaoVotacao(Pauta pauta) {
        return sessaoRepository.findByPauta(pauta);
    }

    @Transactional
    public Voto votar(Long pautaId, Voto voto) {
        var sessaoVotacao = getSessaoVotacao(getPauta(pautaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Pauta não encontrada")))
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Sessão não encontrada"));

        if (LocalDateTime.now().isAfter(sessaoVotacao.getDataFim())) {
            throw new SessaoFechadaException("Sessão fechada");
        }

        voto.setSessaoVotacao(sessaoVotacao);

        if (votoRepository.existsBySessaoVotacaoAndCpfEleitor(sessaoVotacao, voto.getCpfEleitor())) {
            throw new NegocioException("Voto já registrado");
        }
        return votoRepository.save(voto);
    }
}
