package br.com.cp.comparefacilrest.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "td_plano_servico")
public class PlanoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_plano_servico")
    private Long id;

    @ManyToOne
    private Provedora provedora;

    @Column(name = "nme_plano")
    private String nome;

    @Column(name = "vlr_plano")
    private Double valor;

    @Column(name = "dsc_plano")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Provedora getProvedora() {
        return provedora;
    }

    public void setProvedora(Provedora provedora) {
        this.provedora = provedora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
