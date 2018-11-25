package br.com.cp.comparefacilrest.dto;

import br.com.cp.comparefacilrest.model.Colaboracao;
import br.com.cp.comparefacilrest.model.LikeEnum;



public class LikeDTO {


    private Long id;
    private Long idColaboracao;
    private Long idPessoa;
    private LikeEnum flagLike;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdColaboracao() {
        return idColaboracao;
    }

    public void setIdColaboracao(Long idColaboracao) {
        this.idColaboracao = idColaboracao;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public LikeEnum getFlagLike() {
        return flagLike;
    }

    public void setFlagLike(LikeEnum flagLike) {
        this.flagLike = flagLike;
    }
}
