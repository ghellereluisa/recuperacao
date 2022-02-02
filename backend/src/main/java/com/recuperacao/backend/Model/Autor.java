package com.recuperacao.backend.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "autores")
public class Autor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;
    private String nomeAutor;

    @JsonIgnore
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Livro> livro_autor = new ArrayList<>();


    public Autor(){
    }

    public Autor(Long idAutor, String nomeAutor) {
        this.idAutor = idAutor;
        this.nomeAutor = nomeAutor;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public List<Livro> getLivro_autor() {
        return livro_autor;
    }
}
