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

    @ManyToOne
    @JoinColumn(name= "id_emprestimo")
    private Emprestimo emprestimo;


    @ManyToOne
    @JoinColumn(name = "id_Exemplar")
    private Exemplar exemplar;

    @ManyToMany
    @JoinTable(name = "livros_categoria", joinColumns = @JoinColumn(name = "categoria_id"), inverseJoinColumns = @JoinColumn(name = "livro_id"))
    private List<Livro> categoriaLivros;


    public Livro() {
    }

    public Livro(Long idLivro, String nomeLivro, Autor autor, Editora editora, List<Emprestimo> emprestimo_livro, Emprestimo emprestimo, Exemplar exemplar, List<Livro> categoriaLivros) {
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.editora = editora;
        this.emprestimo_livro = emprestimo_livro;
        this.emprestimo = emprestimo;
        this.exemplar = exemplar;
        this.categoriaLivros = categoriaLivros;
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

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public List<Livro> getCategoriaLivros() {
        return categoriaLivros;
    }

    public void setCategoriaLivros(List<Livro> categoriaLivros) {
        this.categoriaLivros = categoriaLivros;
    }
}