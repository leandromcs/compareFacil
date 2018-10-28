package br.com.cp.comparefacilrest.repository;

import br.com.cp.comparefacilrest.model.Colaboracao;
import br.com.cp.comparefacilrest.model.Provedora;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ColaboracaoRepository extends CrudRepository<Colaboracao, Long>{

	List<Colaboracao> findAll();

	@Query("SELECT c FROM Colaboracao c WHERE c.aprovado = 'APROVADO'")
    List<Colaboracao> getColaboracoesAprovadas();
}
