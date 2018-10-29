package br.com.cp.comparefacilrest.dto;

import java.util.Date;

public class AvaliacaoColaboracaoDTO {

    private Long id;
    private Date dataAvaliacao;
    private String comentario;
    private Long idPessoa;
    private Long idColaboracao;

    public AvaliacaoColaboracaoDTO(){}

    public AvaliacaoColaboracaoDTO(Long id, Date dataAvaliacao, String comentario, Long idPessoa, Long idColaboracao) {
        this.id = id;
        this.dataAvaliacao = dataAvaliacao;
        this.comentario = comentario;
        this.idPessoa = idPessoa;
        this.idColaboracao = idColaboracao;
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

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Long getIdColaboracao() {
        return idColaboracao;
    }

    public void setIdColaboracao(Long idColaboracao) {
        this.idColaboracao = idColaboracao;
    }
}
