package br.com.cp.comparefacilrest.repository;

import br.com.cp.comparefacilrest.model.Colaboracao;
import br.com.cp.comparefacilrest.model.Provedora;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.Path;
import java.util.List;

public interface ColaboracaoRepository extends CrudRepository<Colaboracao, Long>{

	List<Colaboracao> findAll();

	@Query("SELECT c FROM Colaboracao c WHERE c.aprovado = 'APROVADO'")
    List<Colaboracao> getColaboracoesAprovadas();


	@Query("SELECT c FROM Colaboracao c WHERE " +
			"c.planoServico.nome LIKE CONCAT('%', :pesquisa,'%') OR " +
			"c.planoServico.descricao LIKE CONCAT('%', :pesquisa,'%') OR " +
			"c.dataCriacao LIKE CONCAT('%', :pesquisa, '%') ")
	List<Colaboracao> getColaboracao(@Param("pesquisa") String pesquisa);
}
