package com.recuperacao.backend.Creator;

import com.recuperacao.backend.Model.Exemplar;

import java.util.ArrayList;
import java.util.List;

public class ExemplarCreator {

    public static List<Exemplar> exemplarListaCreate() {

        List<Exemplar> exemplaresList = new ArrayList<>();
        Exemplar exemplar1 = new Exemplar(1L, LivroCreator.livroCreate());
        Exemplar exemplar2 = new Exemplar(2L, LivroCreator.livroCreate());
        Exemplar exemplar3 = new Exemplar(3L, LivroCreator.livroCreate());
        Exemplar exemplar4 = new Exemplar(4L, LivroCreator.livroCreate());

        exemplaresList.add(exemplar1);
        exemplaresList.add(exemplar2);
        exemplaresList.add(exemplar3);
        exemplaresList.add(exemplar4);

        return exemplaresList;
    }

    public static Exemplar exemplarCreate(){
        Exemplar exemplar = new Exemplar(1L, LivroCreator.livroCreate());
        return exemplar;
    }
}
