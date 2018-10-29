package br.com.cp.comparefacilrest.dto;

import br.com.cp.comparefacilrest.model.Colaboracao;
import br.com.cp.comparefacilrest.model.Pessoa;


import java.util.Date;

public class ComentarioDTO {

    private Long id;
    private Date dataCriacao;
    private String descricao;
    private Pessoa pessoa;
    private Colaboracao colaboracao;

    public ComentarioDTO(Date dataCriacao, String descricao, Pessoa pessoa, Colaboracao comentario) {
        this.dataCriacao = dataCriacao;
        this.descricao = descricao;
        this.pessoa = pessoa;
        this.colaboracao = comentario;
    }

    public ComentarioDTO() {
    }

    public Long getId() {
        return id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Colaboracao getColaboracao() {
        return colaboracao;
    }

    public void setColaboracao(Colaboracao colaboracao) {
        this.colaboracao = colaboracao;
    }
}
