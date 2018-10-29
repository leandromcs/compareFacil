package br.com.cp.comparefacilrest.repository;

import br.com.cp.comparefacilrest.model.AvaliacaoColaboracao;
import br.com.cp.comparefacilrest.model.Colaboracao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AvaliacaoColaboracaoRepository extends CrudRepository<AvaliacaoColaboracao, Long>{

	List<AvaliacaoColaboracao> findAll();

}
