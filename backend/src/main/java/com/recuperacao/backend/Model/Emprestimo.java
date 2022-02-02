package com.recuperacao.backend.Model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "emprestimos")
public class Emprestimo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;

    private Boolean emprestado;

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolcao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

    @OneToOne
    @JoinColumn(name = "id_exemplar")
    private Exemplar exemplar;

    public Emprestimo() {
    }

    public Emprestimo(Long idEmprestimo, Boolean emprestado, LocalDate dataEmprestimo, LocalDate dataDevolcao, Usuario usuario, Livro livro, Exemplar exemplar) {
        this.idEmprestimo = idEmprestimo;
        this.emprestado = emprestado;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolcao = dataDevolcao;
        this.usuario = usuario;
        this.livro = livro;
        this.exemplar = exemplar;
    }

    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Boolean getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(Boolean emprestado) {
        this.emprestado = emprestado;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolcao() {
        return dataDevolcao;
    }

    public void setDataDevolcao(LocalDate dataDevolcao) {
        this.dataDevolcao = dataDevolcao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }
}
