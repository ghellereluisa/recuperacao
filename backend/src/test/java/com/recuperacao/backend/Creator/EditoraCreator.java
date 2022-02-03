package com.recuperacao.backend.Creator;

import com.recuperacao.backend.Model.Editora;

public class EditoraCreator {

    public static Editora editoraCreate(){
        Editora editora = new Editora(1L, "testeEditora");
        return editora;
    }
}
