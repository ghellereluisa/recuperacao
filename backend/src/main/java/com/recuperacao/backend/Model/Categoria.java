package com.recuperacao.backend.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(cascade = CascadeType.ALL)
    private List<Livro> livro_categoria = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Long idCategoria, String nomeCategoria, int prazoCategoria, List<Livro> livro_categoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.prazoCategoria = prazoCategoria;
        this.livro_categoria = livro_categoria;
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

    public List<Livro> getLivro_categoria() {
        return livro_categoria;
    }

    public void setLivro_categoria(List<Livro> livro_categoria) {
        this.livro_categoria = livro_categoria;
    }
}
