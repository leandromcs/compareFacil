package br.com.cp.comparefacilrest.dto;

import br.com.cp.comparefacilrest.model.AprovadoEnum;

import java.util.Date;

public class ColaboracaoDTO {

    private Long id;
    private Date dataCriacao;
    private String descricao;
    private String nome;
    private AprovadoEnum aprovado;
    private String versao;
    private Date dataAtualizacao;
    private Long idPessoa;
    private Long idPlanoServico;

    public ColaboracaoDTO(){}

    public ColaboracaoDTO(Long id, Date dataCriacao, String descricao, String nome, AprovadoEnum aprovado, String versao, Date dataAtualizacao, Long idPessoa, Long idPlanoServico) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.descricao = descricao;
        this.nome = nome;
        this.aprovado = aprovado;
        this.versao = versao;
        this.dataAtualizacao = dataAtualizacao;
        this.idPessoa = idPessoa;
        this.idPlanoServico = idPlanoServico;
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

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Long getIdPlanoServico() {
        return idPlanoServico;
    }

    public void setIdPlanoServico(Long idPlanoServico) {
        this.idPlanoServico = idPlanoServico;
    }
}
