package com.recuperacao.backend.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exemplares")
public class Exemplar implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExemplar;
    private Boolean emprestado;


    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

    @OneToOne
    @JoinColumn(name = "id_emprestimo")
    private Emprestimo emprestimo;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Exemplar() {
    }

    public Exemplar(Long idExemplar, Boolean emprestado, Livro livro, Emprestimo emprestimo, Usuario usuario) {
        this.idExemplar = idExemplar;
        this.emprestado = emprestado;
        this.livro = livro;
        this.emprestimo = emprestimo;
        this.usuario = usuario;
    }

    public Long getIdExemplar() {
        return idExemplar;
    }

    public void setIdExemplar(Long idExemplar) {
        this.idExemplar = idExemplar;
    }

    public Boolean getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(Boolean emprestado) {
        this.emprestado = emprestado;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
