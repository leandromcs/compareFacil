package br.com.cp.comparefacilrest.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf_pessoa")
    private String cpf;

    @Column(name = "nme_pessoa")
    private String nome;

    @Column(name = "eml_pessoa")
    private String email;

    @Column(name = "pwd_pessoa")
    private String password;

    @Column(name = "dta_nascimento")
    private Date dataNascimento;

    @Column(name = "dti_ultimo_acesso")
    private Date ultimoAcesso;

    @Column(name = "sts_ativo")
    @Enumerated(EnumType.STRING)
    private AtivoEnum ativo;

    @Column(name = "sts_cargo")
    @Enumerated(EnumType.STRING)
    private CargoEnum cargo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public AtivoEnum getAtivo() {
        return ativo;
    }

    public void setAtivo(AtivoEnum ativo) {
        this.ativo = ativo;
    }

    public CargoEnum getCargo() {
        return cargo;
    }

    public void setCargo(CargoEnum cargo) {
        this.cargo = cargo;
    }
}
