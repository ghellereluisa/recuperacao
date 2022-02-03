package com.recuperacao.backend.Creator;

import com.recuperacao.backend.Model.Emprestimo;

import java.time.LocalDate;

public class EmprestimoCreator {

    public static Emprestimo emprestimoCreate(){
        Emprestimo emprestimo = new Emprestimo(1L, Boolean.TRUE, LocalDate.now(), LocalDate.ofYearDay(2022, 72), emprestimoCreate().getUsuario(), emprestimoCreate().getLivro(), emprestimoCreate().getExemplar());
        return emprestimo;
    }
}
