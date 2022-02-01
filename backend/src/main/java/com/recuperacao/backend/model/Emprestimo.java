package com.recuperacao.backend.model;

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


    private LocalDate dataEmprestimo;
    private LocalDate dataFinal;
    private LocalDate dataDevolcao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

    public Emprestimo() {
    }

    public Emprestimo(Long idEmprestimo, LocalDate dataEmprestimo, LocalDate dataFinal, LocalDate dataDevolcao, Usuario usuario) {
        this.idEmprestimo = idEmprestimo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataFinal = dataFinal;
        this.dataDevolcao = dataDevolcao;
        this.usuario = usuario;
    }

    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
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
}
