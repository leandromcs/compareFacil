package br.com.cp.comparefacilrest.service.impl;

import br.com.cp.comparefacilrest.dto.LikeDTO;
import br.com.cp.comparefacilrest.model.Colaboracao;
import br.com.cp.comparefacilrest.model.Like;
import br.com.cp.comparefacilrest.model.Pessoa;
import br.com.cp.comparefacilrest.repository.ColaboracaoRepository;
import br.com.cp.comparefacilrest.repository.LikeRepository;
import br.com.cp.comparefacilrest.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class LikeServiceImpl {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ColaboracaoRepository colaboracaoRepository;



    public Like save(LikeDTO dto) {

       //Optional<Pessoa> pessoa = this.pessoaRepository.findById(dto.getIdPessoa());
       Optional<Colaboracao> colaboracao = this.colaboracaoRepository.findById(dto.getIdColaboracao());

       Like like = new Like(colaboracao.get(),null,dto.getFlagLike());

       return this.likeRepository.save(like);
    }

    public List<Like> findAll() {
        return this.likeRepository.findAll();
    }
}
