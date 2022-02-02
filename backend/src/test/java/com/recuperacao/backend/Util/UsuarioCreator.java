package com.recuperacao.backend.Util;

import com.recuperacao.backend.Model.Usuario;

public class UsuarioCreator {

    public static Usuario usuarioCreate(){
        Usuario usuario = new Usuario(1L, "usuarioTeste1", "11586032909", "91804883", "exemploRefRes", "exemploRefCom", "EmailTeste", "991281754", true);
        return usuario;
    }
}
