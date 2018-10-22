package br.com.cp.comparefacilrest.service;

import br.com.cp.comparefacilrest.dto.PessoaDTO;
import br.com.cp.comparefacilrest.model.Pessoa;

import java.util.List;

public interface PessoaService {

    Pessoa save(PessoaDTO dto);

    List<Pessoa> findAll();

    Pessoa update(PessoaDTO dto);

    void delete(Long id);
}




