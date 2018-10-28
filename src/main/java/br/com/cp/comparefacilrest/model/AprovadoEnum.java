package br.com.cp.comparefacilrest.model;

public enum AprovadoEnum {

    APROVADO("A"), REPROVADO("R"), PENDENTE("P");

    private String descricao;

    AprovadoEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
