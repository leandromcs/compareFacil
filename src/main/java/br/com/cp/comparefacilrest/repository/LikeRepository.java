package br.com.cp.comparefacilrest.repository;

import br.com.cp.comparefacilrest.model.Like;
import br.com.cp.comparefacilrest.model.Pessoa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface LikeRepository extends CrudRepository<Like, Long> {

     @Query("SELECT COUNT (l.flagLike) FROM Like l WHERE l.flagLike = 'LIKE' AND l.colaboracao.id = :id ")
     Long countLike(@Param("id") Long id);

     @Query("SELECT COUNT (l.flagLike) FROM Like l WHERE l.flagLike = 'DESLIKE' AND l.colaboracao.id = :id  ")
     Long countDeslike(@Param("id") Long id);

     @Query("SELECT l FROM Like l WHERE l.pessoa.id = :idPessoa AND l.colaboracao.id = :idColaboracao")
     Optional<Like> findLikeByIdPessoaAndIdColaboracao(@Param("idPessoa") Long idPessoa, @Param("idColaboracao")Long idColaboracao);


}
