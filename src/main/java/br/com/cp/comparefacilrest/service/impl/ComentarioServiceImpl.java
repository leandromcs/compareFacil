package br.com.cp.comparefacilrest.service.impl;

import br.com.cp.comparefacilrest.dto.ComentarioDTO;
import br.com.cp.comparefacilrest.exception.NegocioException;
import br.com.cp.comparefacilrest.model.Comentario;
import br.com.cp.comparefacilrest.repository.ColaboracaoRepository;
import br.com.cp.comparefacilrest.repository.ComentarioRepository;
import br.com.cp.comparefacilrest.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ComentarioServiceImpl {

    @Autowired
    private ColaboracaoRepository repository;
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> getAll() throws NegocioException{
        List<Comentario> comentarios = comentarioRepository.findAll();
        if(comentarios.isEmpty()){
            throw new NegocioException("Não existem Comentarios cadastrados");
        } else {
            return comentarios;
        }
    }

    public Comentario findById(Long id) throws NegocioException{
        Optional<Comentario> consultado = this.comentarioRepository.findById(id);
        Comentario comentario = consultado.get();
        if(comentario != null){
            return comentario;
        } else {
            throw new NegocioException("Não existe Comentario cadastrado com esse id");
        }
    }

    public Comentario save(ComentarioDTO dto) throws NegocioException {

        Comentario comentario = new Comentario(dto.getDataCriacao(), dto.getDescricao(), dto.getPessoa(), dto.getColaboracao());
        Comentario salvado = this.comentarioRepository.save(comentario);
        if(salvado != null){
            return salvado;
        } else {
            throw new NegocioException("Comentario não cadastrada");
        }
    }

    public void delete(Long id) throws NegocioException{
        this.comentarioRepository.deleteById(id);
    }

    public List<Comentario> getComentarioByIdColaboracao(Long id) throws NegocioException{
        return this.comentarioRepository.getComentarioByIdColaboracao(id);
    }
}
