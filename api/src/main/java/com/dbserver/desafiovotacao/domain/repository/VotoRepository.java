package com.dbserver.desafiovotacao.domain.repository;

import com.dbserver.desafiovotacao.domain.model.SessaoVotacao;
import com.dbserver.desafiovotacao.domain.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

    boolean existsBySessaoVotacaoAndCpfEleitor(SessaoVotacao sessaoVotacao, String cpfEleitor);

}
