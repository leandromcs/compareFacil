package br.com.cp.comparefacilrest.service;

import br.com.cp.comparefacilrest.dto.PlanoServicoDTO;
import br.com.cp.comparefacilrest.model.PlanoServico;

import java.util.List;

public interface PlanoServicoService {

    PlanoServico save(PlanoServicoDTO dto);

    List<PlanoServico> findAll();

    PlanoServico update(PlanoServicoDTO dto);

    void delete(Long id);
}




