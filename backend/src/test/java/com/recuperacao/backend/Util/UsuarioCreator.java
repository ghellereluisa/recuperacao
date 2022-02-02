package com.recuperacao.backend.Util;

import com.recuperacao.backend.Model.Usuario;

public class UsuarioCreator {

    public static Usuario usuarioCreate(){
        Usuario usuario = new Usuario(1L, "usuarioTeste1", "11111111", "1111111111", "email1", "exemploRefRes", "exemploRefRes", "123");
        return usuario;
    }
}
