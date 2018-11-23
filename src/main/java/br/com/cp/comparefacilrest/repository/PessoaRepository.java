package br.com.cp.comparefacilrest.repository;

import br.com.cp.comparefacilrest.model.Pessoa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

	List<Pessoa> findAll();

	@Query("SELECT p FROM Pessoa p WHERE p.ativo = 'ATIVO' ")
    List<Pessoa> getPessoasAtivas();

	Optional<Pessoa> findById(Long id);
}
