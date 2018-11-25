package br.com.cp.comparefacilrest.model;

public enum LikeEnum {

    LIKE("L"), DESLIKE("D");

    private String descricao;


    LikeEnum(String descricao) {this.descricao = descricao;}

    public String getDescricao() {
        return descricao;
    }



}


