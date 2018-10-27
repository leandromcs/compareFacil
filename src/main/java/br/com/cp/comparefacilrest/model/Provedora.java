package br.com.cp.comparefacilrest.model;

import javax.persistence.*;

@Entity
@Table(name = "td_provedora")
public class Provedora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_provedora")
    private Long id;

    @Column(name = "nme_provedora")
    private String nome;

    @Column(name = "url_provedora")
    private String url;

    public Provedora(){}

    public Provedora(Long id, String nome, String url){
        this.id = id;
        this.nome = nome;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
