package br.com.cp.comparefacilrest.service.impl;

import br.com.cp.comparefacilrest.dto.ColaboracaoDTO;
import br.com.cp.comparefacilrest.exception.NegocioException;
import br.com.cp.comparefacilrest.model.AprovadoEnum;
import br.com.cp.comparefacilrest.model.Colaboracao;
import br.com.cp.comparefacilrest.model.PlanoServico;
import br.com.cp.comparefacilrest.repository.ColaboracaoRepository;
import br.com.cp.comparefacilrest.repository.PessoaRepository;
import br.com.cp.comparefacilrest.repository.PlanoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ColaboracaoServiceImpl {

    @Autowired
    private ColaboracaoRepository repository;

    @Autowired
    private PlanoServicoRepository planoServicoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    private byte[] image;

    public List<Colaboracao> getAll() throws NegocioException{
        List<Colaboracao> colaboracaos = repository.findAll();
        if(colaboracaos.equals(null)){
            throw new NegocioException("Não existe Colaboracaos cadastradas");
        } else {
            return colaboracaos;
        }
    }

    public Colaboracao findById(Long id) throws NegocioException{
        Optional<Colaboracao> consultado = this.repository.findById(id);
        Colaboracao colaboracao = consultado.get();
        if(colaboracao != null){
            return colaboracao;
        } else {
            throw new NegocioException("Não existe Colaboracao cadastrada com esse id");
        }
    }

    public List<Colaboracao> getColaboracoesAprovadas(){
        return this.repository.getColaboracoesAprovadas();

    }
//    @Transactional(propagation = Propagation.REQUIRED) //Tava dando erro de transição ao dar save
    @Transactional
    public Colaboracao save(ColaboracaoDTO dto) throws NegocioException {
        Optional<PlanoServico> consultado = this.planoServicoRepository.findById(dto.getPlanoServico().getId());

        Colaboracao colaboracao = new Colaboracao(new Date(), dto.getDescricao(), dto.getNome(), AprovadoEnum.PENDENTE, dto.getVersao(), dto.getDataAtualizacao(), dto.getPessoa(), consultado.get(),dto.getImagem());
        Colaboracao salvado = this.repository.save(colaboracao);
        if(salvado != null){
            return salvado;
        } else {
            throw new NegocioException("Colaboracao não cadastrada");
        }
    }

    public void delete(Long id) throws NegocioException{
        this.repository.deleteById(id);
    }

    public List<Colaboracao> dynamicSearch(String pesquisa) throws NegocioException{
       return this.repository.getColaboracao(pesquisa);
    }

    public Colaboracao atualizarColaboracao(ColaboracaoDTO dto) throws NegocioException{
        Optional<Colaboracao> consultado = this.repository.findById(dto.getId());
        Colaboracao colaboracao = consultado.get();

        colaboracao.setDescricao(dto.getDescricao());
        colaboracao.setNome(dto.getNome());
        colaboracao.setAprovado(dto.getAprovado());
        colaboracao.setVersao(dto.getVersao());
        colaboracao.setDataAtualizacao(dto.getDataAtualizacao());
        Colaboracao atualizado = this.repository.save(colaboracao);

        if(atualizado != null){
            return atualizado;
        } else {
            throw new NegocioException("Problema ao atualizar entidade");
        }
    }

    public byte[] convertImage(MultipartFile file) throws IOException {

        return this.image = file.getBytes();

    }
}