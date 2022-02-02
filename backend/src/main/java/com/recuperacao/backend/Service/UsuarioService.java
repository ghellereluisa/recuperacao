package com.recuperacao.backend.Service;


import com.recuperacao.backend.Repository.UsuarioRepository;
import com.recuperacao.backend.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listUsuario(){
        return usuarioRepository.findAll();
    }

    public Usuario ListUsuarioId(Long idUsuario) {
        Optional<Usuario> idReturn = usuarioRepository.findById(idUsuario);
        return idReturn.get();
    }

    public Usuario CadUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void DelUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    public Usuario AltUsuario(Long idUsuario, Usuario idReturn) {
        Usuario usuarioEnt = usuarioRepository.findById(idUsuario).get();
        UpdateInfo(usuarioEnt, idReturn);
        return usuarioRepository.save(usuarioEnt);
    }

    private void UpdateInfo(Usuario usuarioEnt, Usuario idReturn){
        usuarioEnt.setNomeUsuario(idReturn.getNomeUsuario());
        usuarioEnt.setEmailUsuario(idReturn.getEmailUsuario());
        usuarioEnt.setRgUsuario(idReturn.getRgUsuario());
        usuarioEnt.setCpfUsuario(idReturn.getCpfUsuario());
        usuarioEnt.setRefEnderecoCom(idReturn.getRefEnderecoCom());
        usuarioEnt.setRefEnderecoRes(idReturn.getRefEnderecoRes());
        usuarioEnt.setTelefoneUsuario(idReturn.getTelefoneUsuario());
    }


}
