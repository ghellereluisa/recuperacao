package com.recuperacao.backend.Creator;

import com.recuperacao.backend.Model.Exemplar;

public class ExemplarCreator {

    public static Exemplar exemplarCreate(){
        Exemplar exemplar = new Exemplar(1L, LivroCreator.unidadeLivro());
        return exemplar;
    }
}
