package br.com.cp.comparefacilrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ta_like")
public class Like {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_like")
    private Long id;

    @ManyToOne
    private Colaboracao colaboracao;

    @ManyToOne
    private Pessoa pessoa;

    @Column(name = "flg_like")
    @Enumerated(EnumType.STRING)
    private LikeEnum flagLike;

    public Like(Colaboracao colaboracao, Pessoa pessoa, LikeEnum flagLike) {
        this.colaboracao = colaboracao;
        this.pessoa = pessoa;
        this.flagLike = flagLike;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Colaboracao getColaboracao() {
        return colaboracao;
    }

    public void setColaboracao(Colaboracao colaboracao) {
        this.colaboracao = colaboracao;
    }

    public LikeEnum getFlagLike() {
        return flagLike;
    }

    public void setFlagLike(LikeEnum flagLike) {
        this.flagLike = flagLike;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
