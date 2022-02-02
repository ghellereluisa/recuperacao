package com.recuperacao.backend.Util;

import com.recuperacao.backend.Model.Categoria;

public class CategoriaCreator {

    public static Categoria categoriaCreate(){
        Categoria categoria = new Categoria(1L, "testeCategoria");
        return categoria;
    }
}
