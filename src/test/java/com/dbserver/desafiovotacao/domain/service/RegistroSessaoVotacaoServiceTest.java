package com.dbserver.desafiovotacao.domain.service;

import com.dbserver.desafiovotacao.domain.model.Pauta;
import com.dbserver.desafiovotacao.domain.model.SessaoVotacao;
import com.dbserver.desafiovotacao.domain.repository.PautaRepository;
import com.dbserver.desafiovotacao.domain.repository.SessaoVotacaoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RegistroSessaoVotacaoServiceTest {

    @Mock
    private PautaRepository pautaRepositoryMock;

    @Mock
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @InjectMocks
    private RegistroSessaoVotacaoService registroSessaoVotacaoService;

    @BeforeEach()
    void setUp() {
       when(pautaRepositoryMock.findById(ArgumentMatchers.anyLong()))
               .thenReturn(Optional.of(criarPauta()));

       when(sessaoVotacaoRepository.save(ArgumentMatchers.any(SessaoVotacao.class)))
               .thenReturn(criarSessaoVotacao());
    }

    @Test
    void Dado_uma_iniciacao_de_votos_Quando_registrar_Entao_deve_retornar_sucesso() {
        var sessaoVotacao = registroSessaoVotacaoService.iniciarSessaoVotacao(1L, LocalDateTime.now());

        Assertions.assertThat(sessaoVotacao)
                .isNotNull();
    }

    @Test
    void Dado_uma_data_fim_null_Quando_criar_Entao_deve_retornar_exception() {
        assertThrows(IllegalArgumentException.class, () -> registroSessaoVotacaoService.iniciarSessaoVotacao(1L, null));
    }

    private SessaoVotacao criarSessaoVotacao() {
        return SessaoVotacao
                .builder()
                .dataInicio(LocalDateTime.now())
                .dataFim(LocalDateTime.now())
                .pauta(criarPauta())
                .build();
    }

    private Pauta criarPauta() {
        return Pauta.builder()
                .nome("Campanha de marca")
                .dataInicio(LocalDateTime.now())
                .descricao("Reunião inicia às 17:00")
                .build();
    }
}