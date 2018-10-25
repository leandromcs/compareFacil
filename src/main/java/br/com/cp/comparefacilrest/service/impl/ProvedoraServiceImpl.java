package br.com.cp.comparefacilrest.service.impl;

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
}
