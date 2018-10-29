package br.com.cp.comparefacilrest.dto;


import br.com.cp.comparefacilrest.model.Provedora;

public class PlanoServicoDTO  {

    private Long id;
    private Provedora provedora;
    private String nome;
    private Float valor;
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

    public Float getValor() {
        return valor;
    }    

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
