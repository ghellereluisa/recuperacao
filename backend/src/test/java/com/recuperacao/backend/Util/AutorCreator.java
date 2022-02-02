package com.recuperacao.backend.Util;

import com.recuperacao.backend.Model.Autor;

public class AutorCreator {

    public static Autor autorCreate(){
        Autor autor = new Autor(1L, "testeAutor");

        return autor;
    }


}
