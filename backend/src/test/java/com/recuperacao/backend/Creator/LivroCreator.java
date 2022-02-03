package com.recuperacao.backend.Creator;

import com.recuperacao.backend.Model.Livro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LivroCreator {

    public static List<Livro> livroCreate(){
        List<Livro> praSalvarLivros = new ArrayList<>();

        Livro livroTeste1 = new Livro(1L, "Cidade dos Ossos", AutorCreator.autorCreate(), EditoraCreator.editoraCreate(), CategoriaCreator.categoriaCreate());

        praSalvarLivros.add(livroTeste1);


        return praSalvarLivros;
    }

    public static Livro unidadeLivro(){
        Livro livro = new Livro(1L, "Cidade dos Ossos", AutorCreator.autorCreate(), EditoraCreator.editoraCreate(), CategoriaCreator.categoriaCreate());
        return livro;
    }

}
