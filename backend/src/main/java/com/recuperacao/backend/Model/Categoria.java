package com.recuperacao.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;
    private String nomeCategoria;
    private int prazoCategoria;


    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Livro> lista_livro = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Long idCategoria, String nomeCategoria, int prazoCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.prazoCategoria = prazoCategoria;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public int getPrazoCategoria() {
        return prazoCategoria;
    }

    public void setPrazoCategoria(int prazoCategoria) {
        this.prazoCategoria = prazoCategoria;
    }

    public List<Livro> getLista_livro() {
        return lista_livro;
    }

}
