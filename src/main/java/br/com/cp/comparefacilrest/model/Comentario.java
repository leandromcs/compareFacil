package br.com.cp.comparefacilrest.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ta_comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_colaboracao")
    private Long id;

    @Column(name = "dti_criacao_comentario")
    private Date dataCriacao;

    @Column(name = "dsc_comentario")
    private String descricao;

    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne
    private Colaboracao colaboracao;

    public Comentario(Date dataCriacao, String descricao, Pessoa pessoa, Colaboracao comentario) {
        this.dataCriacao = dataCriacao;
        this.descricao = descricao;
        this.pessoa = pessoa;
        this.colaboracao = comentario;
    }

    public Comentario() {
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
