package br.com.cp.comparefacilrest.repository;

import br.com.cp.comparefacilrest.model.Colaboracao;
import br.com.cp.comparefacilrest.model.Comentario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ComentarioRepository extends CrudRepository<Comentario, Long>{

	List<Comentario> findAll();

	@Query("SELECT c FROM Comentario c")
    List<Colaboracao> getColaboracoesAprovadas();

	@Query("SELECT comentario.id FROM Comentario comentario WHERE comentario.colaboracao.id = :id")
	List<Long> getComentarioByIdColaboracao(@Param("id") Long id);

	List<Comentario> findById(List<Long> id);
}
