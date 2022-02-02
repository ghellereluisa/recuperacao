package com.recuperacao.backend.Util;

import com.recuperacao.backend.Model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroCreator {

    public static List<Livro> livroCreate(){
        List<Livro> praSalvarLivros = new ArrayList<>();

        Livro livroTeste1 = new Livro(1L,"test1", 4, CategoriaCreator.categoriaCreate(),AutorCreator.autorCreate(), EditoraCreator.editoraCreate());
        Livro livroTeste2 = new Livro(2L,"test2", 6, CategoriaCreator.categoriaCreate(),AutorCreator.autorCreate(), EditoraCreator.editoraCreate());

        praSalvarLivros.add(livroTeste1);
        praSalvarLivros.add(livroTeste2);

        return praSalvarLivros;
    }

    public static Livro unidadeLivro(){
        Livro livro = new Livro(1L,"test1", 4, CategoriaCreator.categoriaCreate(),AutorCreator.autorCreate(), EditoraCreator.editoraCreate());
        return livro;
    }

}
