package com.recuperacao.backend.Util;

import com.recuperacao.backend.Model.Emprestimo;

import java.time.LocalDate;

public class EmprestimoCreator {

    public static Emprestimo emprestimoCreate(){
        Emprestimo emprestimo = new Emprestimo(1L, LocalDate.now(),LocalDate.plusDays(LivroCreator.livroCreate().getCategoria.getLimiteEmprestimo()), LivroCreator.unidadeLivro(), UsuarioCreator.usuarioCreate());
        return emprestimo;
    }
}