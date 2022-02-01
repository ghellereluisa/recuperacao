package com.recuperacao.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


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

    @JsonIgnore
    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimo_livro;

    public Livro() {
    }

    public Livro(Long idLivro, String nomeLivro, Autor autor, Editora editora, List<Emprestimo> emprestimo_livro) {
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.editora = editora;
        this.emprestimo_livro = emprestimo_livro;
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

    public List<Emprestimo> getEmprestimo_livro() {
        return emprestimo_livro;
    }

    public void setEmprestimo_livro(List<Emprestimo> emprestimo_livro) {
        this.emprestimo_livro = emprestimo_livro;
    }
}