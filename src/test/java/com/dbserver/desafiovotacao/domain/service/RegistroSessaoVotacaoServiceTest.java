package com.dbserver.desafiovotacao.domain.service;

import com.dbserver.desafiovotacao.domain.model.Pauta;
import com.dbserver.desafiovotacao.domain.model.SessaoVotacao;
import com.dbserver.desafiovotacao.domain.repository.SessaoVotacaoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RegistroSessaoVotacaoServiceTest {

    @Mock
    private SessaoVotacaoRepository sessaoVotacaoRepositoryMock;

    @InjectMocks
    private RegistroSessaoVotacaoService registroSessaoVotacaoService;

    @BeforeEach()
    void setUp() {
        BDDMockito.when(sessaoVotacaoRepositoryMock.save(ArgumentMatchers.any(SessaoVotacao.class)))
                .thenReturn(criarSessaoVotacao());
    }



    private SessaoVotacao criarSessaoVotacao() {
        var pauta = Pauta.builder()
                        .nome("Campanha de marca")
                        .dataInicio(LocalDateTime.now())
                        .descricao("Reunião inicia às 17:00")
                        .build();

        return SessaoVotacao
                .builder()
                .dataInicio(LocalDateTime.now())
                .dataInicio(LocalDateTime.now())
                .pauta(pauta)
                .build();
    }
}