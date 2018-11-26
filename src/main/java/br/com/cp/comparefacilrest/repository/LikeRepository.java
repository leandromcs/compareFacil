package br.com.cp.comparefacilrest.repository;

import br.com.cp.comparefacilrest.model.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface LikeRepository extends CrudRepository<Like, Long> {

     @Query("SELECT COUNT (l.flagLike) FROM Like l WHERE l.flagLike = 'LIKE' AND l.colaboracao.id = :id ")
     Long countLike(@Param("id") Long id);

     @Query("SELECT COUNT (l.flagLike) FROM Like l WHERE l.flagLike = 'DESLIKE' AND l.colaboracao.id = :id  ")
     Long countDeslike(@Param("id") Long id);
}
