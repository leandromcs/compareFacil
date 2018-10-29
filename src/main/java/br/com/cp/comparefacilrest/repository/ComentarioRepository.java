package br.com.cp.comparefacilrest.repository;

import br.com.cp.comparefacilrest.model.Colaboracao;
import br.com.cp.comparefacilrest.model.Comentario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComentarioRepository extends CrudRepository<Comentario, Long>{

	List<Comentario> findAll();

	@Query("SELECT c FROM Comentario c")
    List<Colaboracao> getColaboracoesAprovadas();
}
