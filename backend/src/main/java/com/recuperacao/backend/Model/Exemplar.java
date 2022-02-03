package com.recuperacao.backend.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exemplares")
public class Exemplar implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExemplar;


    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

    @JsonIgnore
    @OneToMany(mappedBy = "emprestimo_exemplar", cascade = CascadeType.ALL)
    private List<Emprestimo> lista_emprestimo = new ArrayList<>();


    public Exemplar() {
    }

    public Exemplar(Long idExemplar, Livro livro) {
        this.idExemplar = idExemplar;
        this.livro = livro;
    }

    public Long getIdExemplar() {
        return idExemplar;
    }

    public void setIdExemplar(Long idExemplar) {
        this.idExemplar = idExemplar;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Emprestimo> getLista_emprestimo() {
        return lista_emprestimo;
    }
}
