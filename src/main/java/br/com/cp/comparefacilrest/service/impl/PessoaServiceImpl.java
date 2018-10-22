package br.com.cp.comparefacilrest.service.impl;

import br.com.cp.comparefacilrest.dto.PessoaDTO;
import br.com.cp.comparefacilrest.model.Pessoa;
import br.com.cp.comparefacilrest.repository.PessoaRepository;
import br.com.cp.comparefacilrest.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Pessoa save(PessoaDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(dto.getId());
        pessoa.setNome(dto.getNome());

        return pessoaRepository.save(pessoa);
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Pessoa update(PessoaDTO dto) {
        Optional<Pessoa> consultado = this.pessoaRepository.findById(dto.getId());
        Pessoa pessoa = consultado.get();

        pessoa.setId(dto.getId());
        pessoa.setNome(dto.getNome());

        return pessoaRepository.save(pessoa);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        Optional<Pessoa> consultado = this.pessoaRepository.findById(id);
        Pessoa pessoa = consultado.get();
        pessoaRepository.delete(pessoa);
    }


}
