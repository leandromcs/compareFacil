package br.com.cp.comparefacilrest.model;

public enum AtivoEnum {

    ATIVO("A"), INATIVO("I");

    private String descricao;

    AtivoEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
