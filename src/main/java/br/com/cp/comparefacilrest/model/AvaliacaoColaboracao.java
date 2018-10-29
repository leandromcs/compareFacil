package br.com.cp.comparefacilrest.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ta_avaliacao_colaboracao")
public class AvaliacaoColaboracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_avaliacao_colaboracao")
    private Long id;

    @Column(name = "dti_avaliacao")
    private Date dataAvaliacao;

    @Column(name = "cmt_avaliacao")
    private String comentario;

    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne
    private Colaboracao colaboracao;

    public AvaliacaoColaboracao(Date dataAvaliacao, String comentario, Pessoa pessoa, Colaboracao colaboracao) {
        this.dataAvaliacao = dataAvaliacao;
        this.comentario = comentario;
        this.pessoa = pessoa;
        this.colaboracao = colaboracao;
    }

    public AvaliacaoColaboracao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
