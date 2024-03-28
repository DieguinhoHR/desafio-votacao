package com.dbserver.desafiovotacao.domain.service;

import com.dbserver.desafiovotacao.domain.exception.EntidadeNaoEncontradaException;
import com.dbserver.desafiovotacao.domain.model.Pauta;
import com.dbserver.desafiovotacao.domain.repository.PautaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroPautaService {

    private final PautaRepository pautaRepository;

    @Transactional
    public Pauta salvar(Pauta pauta) {
       return pautaRepository.save(pauta);
    }

    public Pauta buscarPorId(Long pautaId) {
        return pautaRepository.findById(pautaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Pauta não encontrada"));
    }
}
