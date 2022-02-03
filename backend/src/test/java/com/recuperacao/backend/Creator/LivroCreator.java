package com.recuperacao.backend.Creator;

import com.recuperacao.backend.Model.Livro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LivroCreator {
    public static Livro livroCreate(){
        Livro livro = new Livro(1L, "Cidade dos Ossos", AutorCreator.autorCreate(), EditoraCreator.editoraCreate(), CategoriaCreator.categoriaCreate());
        return livro;
    }

}
