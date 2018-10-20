package br.com.cp.comparefacilrest.model;

public enum CargoEnum {

    ADMINISTRADOR("ADM"), COLABORADOR("CLB");

    private String descricao;

    CargoEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
