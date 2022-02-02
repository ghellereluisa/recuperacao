package com.recuperacao.backend.Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nomeUsuario;
    private String cpfUsuario;
    private String rgUsuario;
    private String refEnderecoRes;
    private String refEnderecoCom;
    private String emailUsuario;
    private String telefoneUsuario;
    private Boolean isAdmin;



    public Usuario() {
    }

    public Usuario(Long idUsuario, String nomeUsuario, String cpfUsuario, String rgUsuario, String refEnderecoRes, String refEnderecoCom, String emailUsuario, String telefoneUsuario, Boolean isAdmin) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.cpfUsuario = cpfUsuario;
        this.rgUsuario = rgUsuario;
        this.refEnderecoRes = refEnderecoRes;
        this.refEnderecoCom = refEnderecoCom;
        this.emailUsuario = emailUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.isAdmin = isAdmin;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getRgUsuario() {
        return rgUsuario;
    }

    public void setRgUsuario(String rgUsuario) {
        this.rgUsuario = rgUsuario;
    }

    public String getRefEnderecoRes() {
        return refEnderecoRes;
    }

    public void setRefEnderecoRes(String refEnderecoRes) {
        this.refEnderecoRes = refEnderecoRes;
    }

    public String getRefEnderecoCom() {
        return refEnderecoCom;
    }

    public void setRefEnderecoCom(String refEnderecoCom) {
        this.refEnderecoCom = refEnderecoCom;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
