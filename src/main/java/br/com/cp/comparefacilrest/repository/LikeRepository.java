package br.com.cp.comparefacilrest.repository;

import br.com.cp.comparefacilrest.model.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikeRepository extends CrudRepository<Like, Long> {

    @Query("SELECT l FROM Like l")
     List<Like> findAll();
}
