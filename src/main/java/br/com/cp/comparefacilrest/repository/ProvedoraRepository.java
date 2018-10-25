package br.com.cp.comparefacilrest.repository;

import br.com.cp.comparefacilrest.model.Provedora;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProvedoraRepository extends CrudRepository<Provedora, Long>{

	List<Provedora> findAll();

}
