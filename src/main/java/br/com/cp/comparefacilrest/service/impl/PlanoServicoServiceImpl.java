package br.com.cp.comparefacilrest.service.impl;

import br.com.cp.comparefacilrest.dto.PlanoServicoDTO;
import br.com.cp.comparefacilrest.model.PlanoServico;
import br.com.cp.comparefacilrest.repository.PlanoServicoRepository;
import br.com.cp.comparefacilrest.service.PlanoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class PlanoServicoServiceImpl implements PlanoServicoService {

    @Autowired
    private PlanoServicoRepository planoServicoRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public PlanoServico save(PlanoServicoDTO dto) {
        PlanoServico planoServico = new PlanoServico();
        planoServico.setId(dto.getId());
        planoServico.setProvedora(dto.getProvedora());
        planoServico.setNome(dto.getNome());
        planoServico.setValor(dto.getValor());
        planoServico.setDescricao(dto.getDescricao());

        return planoServicoRepository.save(planoServico);
    }

    @Override
    public List<PlanoServico> findAll() {
        return planoServicoRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public PlanoServico update(PlanoServicoDTO dto) {
        Optional<PlanoServico> consultado = this.planoServicoRepository.findById(dto.getId());

        PlanoServico planoServico = consultado.get();
        planoServico.setId(dto.getId());
        planoServico.setProvedora(dto.getProvedora());
        planoServico.setNome(dto.getNome());
        planoServico.setValor(dto.getValor());
        planoServico.setDescricao(dto.getDescricao());

        return planoServicoRepository.save(planoServico);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        Optional<PlanoServico> consultado = this.planoServicoRepository.findById(id);
        PlanoServico planoServico = consultado.get();
        planoServicoRepository.save(planoServico);
    }


}
