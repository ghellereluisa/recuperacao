package com.recuperacao.backend.Creator;

import com.recuperacao.backend.Model.Categoria;

import java.util.HashSet;

public class CategoriaCreator {

    public static Categoria categoriaCreate(){
        Categoria categoria = new Categoria(1L, "testeCategoria",3,  new HashSet<>());
        return categoria;
    }
}
