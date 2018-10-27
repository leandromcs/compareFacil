package br.com.cp.comparefacilrest.service.impl;

import br.com.cp.comparefacilrest.dto.ProvedoraDTO;
import br.com.cp.comparefacilrest.exception.NegocioException;
import br.com.cp.comparefacilrest.model.Provedora;
import br.com.cp.comparefacilrest.repository.ProvedoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ProvedoraServiceImpl {

    @Autowired
    private ProvedoraRepository repository;

    public List<Provedora> getAll() throws NegocioException{
        List<Provedora> provedoras = repository.findAll();
        if(provedoras.isEmpty()){
            throw new NegocioException("Não existe Provedoras cadastradas");
        } else {
            return provedoras;
        }
    }

    public Provedora findById(Long id) throws NegocioException{
        Optional<Provedora> consultado = this.repository.findById(id);
        Provedora provedora = consultado.get();
        if(provedora != null){
            return provedora;
        } else {
            throw new NegocioException("Não existe Provedora cadastrada com esse id");
        }
    }

    public Provedora save(ProvedoraDTO dto) throws NegocioException {

        Provedora provedora = new Provedora(dto.getId(), dto.getNome(), dto.getUrl());
        Provedora salvado = this.repository.save(provedora);
        if(salvado != null){
            return salvado;
        } else {
            throw new NegocioException("Provedora não cadastrada");
        }
    }

    public void delete(Long id) throws NegocioException{
        this.repository.deleteById(id);
    }

    public Provedora atualizarProvedora(ProvedoraDTO dto) throws NegocioException{
        Optional<Provedora> consultado = this.repository.findById(dto.getId());
        Provedora provedora = consultado.get();

        provedora.setNome(dto.getNome());
        provedora.setUrl(dto.getUrl());

        Provedora atualizado = this.repository.save(provedora);

        if(atualizado != null){
            return atualizado;
        } else {
            throw new NegocioException("Problema ao atualizar entidade");
        }
    }
}
