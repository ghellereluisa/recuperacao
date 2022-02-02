package com.recuperacao.backend.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "editoras")
public class Editora implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEditora;
    private String nomeEditora;


    @JsonIgnore
    @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL)
    private List<Livro> livro_editora = new ArrayList<>();

    public Editora(){
    }

    public Editora(Long idEditora, String nomeEditora) {
        this.idEditora = idEditora;
        this.nomeEditora = nomeEditora;
    }


    public Long getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Long idEditora) {
        this.idEditora = idEditora;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    public List<Livro> getLivro_editora() {
        return livro_editora;
    }
}
