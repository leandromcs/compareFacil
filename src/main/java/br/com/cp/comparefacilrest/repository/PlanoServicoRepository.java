package br.com.cp.comparefacilrest.repository;

import br.com.cp.comparefacilrest.model.PlanoServico;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlanoServicoRepository extends CrudRepository<PlanoServico, Long> {

    List<PlanoServico> findAll();
}
