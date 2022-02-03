package com.recuperacao.backend.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="livros")
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;
    private String nomeLivro;


    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_editora")
    private Editora editora;


    @ManyToMany
    @JoinTable(name = "livros_categoria", joinColumns = @JoinColumn(name = "categoria_id"), inverseJoinColumns = @JoinColumn(name = "livro_id"))
    private Set<Livro> categoriaLivro = new HashSet<>();


    public Livro() {
    }

    public Livro(Long idLivro, String nomeLivro, Autor autor, Editora editora, Set<Livro> categoriaLivro) {
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.editora = editora;
        this.categoriaLivro = categoriaLivro;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public void setCategoriaLivro(Set<Livro> categoriaLivro) {
        this.categoriaLivro = categoriaLivro;
    }
}