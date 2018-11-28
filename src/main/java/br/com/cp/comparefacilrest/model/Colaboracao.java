package br.com.cp.comparefacilrest.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_colaboracao")
public class Colaboracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_colaboracao")
    private Long id;

    @Column(name = "dti_criacao_colaboracao")
    private Date dataCriacao;

    @Column(name = "dsc_colaboracao")
    private String descricao;

    @Column(name = "nme_titulo_colaboracao")
    private String nome;

    @Column(name = "sts_aprovacao_colaboracao")
    private AprovadoEnum aprovado;

    @Column(name = "ver_colaboracao")
    private String versao;

    @Column(name = "dti_atualizacao_colaboracao")
    private Date dataAtualizacao;

    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne(fetch = FetchType.EAGER)
    private PlanoServico planoServico;

    @Lob
    @Column (name = "img_colaboracao")
    private byte[] imagem;

    public Colaboracao(Date dataCriacao, String descricao, String nome, AprovadoEnum aprovado, String versao, Date dataAtualizacao, Pessoa pessoa, PlanoServico planoServico, byte[] imagem) {
        this.dataCriacao = dataCriacao;
        this.descricao = descricao;
        this.nome = nome;
        this.aprovado = aprovado;
        this.versao = versao;
        this.dataAtualizacao = dataAtualizacao;
        this.pessoa = pessoa;
        this.planoServico = planoServico;
        this.imagem = imagem;
    }

    public Colaboracao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public AprovadoEnum getAprovado() {
        return aprovado;
    }

    public void setAprovado(AprovadoEnum aprovado) {
        this.aprovado = aprovado;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PlanoServico getPlanoServico() {
        return planoServico;
    }

    public void setPlanoServico(PlanoServico planoServico) {
        this.planoServico = planoServico;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
