package com.dbserver.desafiovotacao.domain.service;

import com.dbserver.desafiovotacao.domain.model.Pauta;
import com.dbserver.desafiovotacao.domain.repository.PautaRepository;
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
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RegistroPautaServiceTest {

    @Mock
    private PautaRepository pautaRepositoryMock;

    @InjectMocks
    private RegistroPautaService registroPautaService;

    @BeforeEach()
    void setUp() {
        BDDMockito.when(pautaRepositoryMock.save(ArgumentMatchers.any(Pauta.class)))
                .thenReturn(criarPauta());

        BDDMockito.when(pautaRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(criarPauta()));
    }

    @Test
    void Dado_uma_pauta_valida_Quando_criar_Entao_deve_retornar_uma_pauta_cadastrada() {
        var pauta = registroPautaService.salvar(criarPauta());
        Assertions.assertThat(pauta).isNotNull();
    }

    @Test
    void Dado_uma_pauta_com_id_valido_Quando_buscar_registro_Entao_deve_retornar_uma_pauta_com_sucesso() {
        Long pautaIdEsperado = criarPauta().getId();

        var sessaoVotacao = pautaRepositoryMock.findById(1L);

        Assertions.assertThat(sessaoVotacao).isNotNull();
        Assertions.assertThat(sessaoVotacao.get().getId())
                .isNotNull()
                .isEqualTo(pautaIdEsperado);
    }

    private Pauta criarPauta() {
        return Pauta
                .builder()
                .id(1L)
                .nome("Campanha de marca")
                .dataInicio(LocalDateTime.now())
                .descricao("Reunião inicia às 17:00")
                .build();
    }
}