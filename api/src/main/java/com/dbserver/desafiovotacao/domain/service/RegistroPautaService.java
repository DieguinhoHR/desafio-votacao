package com.dbserver.desafiovotacao.domain.service;

import com.dbserver.desafiovotacao.domain.model.Pauta;
import com.dbserver.desafiovotacao.domain.model.Voto;
import com.dbserver.desafiovotacao.domain.repository.PautaRepository;
import com.dbserver.desafiovotacao.domain.repository.SessaoVotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Cacheable(value = "pautas", key = "#pauta.id")
public class RegistroPautaService {

    private final PautaRepository pautaRepository;
    private final SessaoVotacaoRepository sessaoVotacaoRepository;

    @CacheEvict(value = "pautas", allEntries = true)
    @Transactional
    public Pauta salvar(Pauta pauta) {
       return pautaRepository.save(pauta);
    }

    public Map<String, Long> exibirResultadoVotacao(Pauta pauta) {
        var buscarPauta = sessaoVotacaoRepository.findByPauta(pauta);

        Collection<Voto> votos = buscarPauta.isPresent()
                ? buscarPauta.get().getVotos()
                : new ArrayList<>();

        Map<String, Long> resultado = new HashMap<>();

        resultado.put("SIM", votos.stream().filter(voto -> voto.getStatusVoto()
                .toString()
                .equalsIgnoreCase("SIM"))
                .count());

        resultado.put("NAO", votos.stream().filter(voto -> voto.getStatusVoto()
                .toString()
                .equalsIgnoreCase("NAO"))
                .count());

        return resultado;
    }
}
