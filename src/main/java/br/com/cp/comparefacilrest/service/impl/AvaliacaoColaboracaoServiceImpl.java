package br.com.cp.comparefacilrest.service.impl;

import br.com.cp.comparefacilrest.dto.AvaliacaoColaboracaoDTO;
import br.com.cp.comparefacilrest.exception.NegocioException;
import br.com.cp.comparefacilrest.model.AvaliacaoColaboracao;
import br.com.cp.comparefacilrest.model.Colaboracao;
import br.com.cp.comparefacilrest.model.Pessoa;
import br.com.cp.comparefacilrest.repository.AvaliacaoColaboracaoRepository;
import br.com.cp.comparefacilrest.repository.ColaboracaoRepository;
import br.com.cp.comparefacilrest.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class AvaliacaoColaboracaoServiceImpl {

    @Autowired
    private AvaliacaoColaboracaoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ColaboracaoRepository colaboracaoRepository;

    public List<AvaliacaoColaboracao> getAll() throws NegocioException{
        List<AvaliacaoColaboracao> avaliacaoColaboracaos = repository.findAll();
        if(avaliacaoColaboracaos.isEmpty()){
            throw new NegocioException("Não existe AvaliacaoColaboracaos cadastradas");
        } else {
            return avaliacaoColaboracaos;
        }
    }

    public AvaliacaoColaboracao findById(Long id) throws NegocioException{
        Optional<AvaliacaoColaboracao> consultado = this.repository.findById(id);
        AvaliacaoColaboracao avaliacaoColaboracao = consultado.get();
        if(avaliacaoColaboracao != null){
            return avaliacaoColaboracao;
        } else {
            throw new NegocioException("Não existe AvaliacaoColaboracao cadastrada com esse id");
        }
    }

    public AvaliacaoColaboracao save(AvaliacaoColaboracaoDTO dto) throws NegocioException {

        Optional<Colaboracao> colaboracao = colaboracaoRepository.findById(dto.getIdColaboracao());
        Optional<Pessoa> pessoa = pessoaRepository.findById(dto.getIdPessoa());

        AvaliacaoColaboracao avaliacaoColaboracao =
                new AvaliacaoColaboracao(dto.getDataAvaliacao(), dto.getComentario(), pessoa.get(), colaboracao.get());
        AvaliacaoColaboracao salvado = this.repository.save(avaliacaoColaboracao);
        if(salvado != null){
            return salvado;
        } else {
            throw new NegocioException("AvaliacaoColaboracao não cadastrada");
        }
    }

    public void delete(Long id) throws NegocioException{
        this.repository.deleteById(id);
    }

    public AvaliacaoColaboracao atualizarAvaliacaoColaboracao(AvaliacaoColaboracaoDTO dto) throws NegocioException{
        Optional<AvaliacaoColaboracao> consultado = this.repository.findById(dto.getId());
        AvaliacaoColaboracao avaliacaoColaboracao = consultado.get();

        avaliacaoColaboracao.setComentario(dto.getComentario());
        AvaliacaoColaboracao atualizado = this.repository.save(avaliacaoColaboracao);

        if(atualizado != null){
            return atualizado;
        } else {
            throw new NegocioException("Problema ao atualizar entidade");
        }
    }
}
