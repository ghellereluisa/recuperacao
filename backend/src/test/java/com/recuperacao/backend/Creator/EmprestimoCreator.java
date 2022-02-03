package com.recuperacao.backend.Creator;

import com.recuperacao.backend.Model.Emprestimo;

import java.time.LocalDate;

public class EmprestimoCreator {

    public static Emprestimo emprestimoCreate(){
        Emprestimo emprestimo = new Emprestimo(1L, Boolean.TRUE, LocalDate.now(), LocalDate.now().plusDays(ExemplarCreator.exemplarCreate().getLivro().getCategoria().getPrazoCategoria()), UsuarioCreator.usuarioCreate(), ExemplarCreator.exemplarCreate());
        return emprestimo;
    }
}
