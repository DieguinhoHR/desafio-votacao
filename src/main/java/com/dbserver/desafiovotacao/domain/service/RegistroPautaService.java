package com.dbserver.desafiovotacao.domain.service;

import com.dbserver.desafiovotacao.domain.model.Pauta;
import com.dbserver.desafiovotacao.domain.model.Voto;
import com.dbserver.desafiovotacao.domain.repository.PautaRepository;
import com.dbserver.desafiovotacao.domain.repository.SessaoVotacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;

@AllArgsConstructor
@Service
public class RegistroPautaService {

    @Value("${tempo.sessao.votacao.segundos}")
    private Integer tempoSessaoPadrao;

    private final PautaRepository pautaRepository;
    private final SessaoVotacaoRepository sessaoVotacaoRepository;

    @Transactional
    public Pauta salvar(Pauta pauta) {
       return pautaRepository.save(pauta);
    }

    public Map<String, Long> exibirResultadoVotacao(Pauta pauta) {
        var buscarPauta = sessaoVotacaoRepository.findByPauta(pauta);

        Collection<Voto> votos = buscarPauta.isPresent()
                ? buscarPauta.get().getVotos()
                : new ArrayList<>();

        Map<String, Long> result = new HashMap<>();
        result.put("SIM", votos.stream().filter(voto -> voto.getStatusVoto()
                .toString()
                .equalsIgnoreCase("SIM"))
                .count());
        result.put("NAO", votos.stream().filter(voto -> voto.getStatusVoto()
                .toString()
                .equalsIgnoreCase("NAO"))
                .count());

        return result;
    }
}
