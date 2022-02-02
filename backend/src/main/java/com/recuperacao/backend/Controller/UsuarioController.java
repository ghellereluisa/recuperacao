package com.recuperacao.backend.Controller;

import com.recuperacao.backend.Service.UsuarioService;
import com.recuperacao.backend.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listaUsuario() {
        return usuarioService.listUsuario();
    }

    @GetMapping(value = "/{idUsuario}")
    public ResponseEntity<Usuario> listaUsuarioId(@PathVariable Long idUsuario) {
        Usuario idReturn = usuarioService.ListUsuarioId(idUsuario);
        return ResponseEntity.ok().body(idReturn);
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastraUsuario (@RequestBody Usuario usuario){
        usuario = usuarioService.CadUsuario(usuario);
        return ResponseEntity.ok().body(usuario);
    }

    @PutMapping(value = "/{idUsuario}")
    public ResponseEntity<Usuario> alteraUsuario(@PathVariable Long idUsuario, @RequestBody Usuario usuario){
        usuario = usuarioService.AltUsuario(idUsuario, usuario);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping(value = "/{idUsuario}")
    public ResponseEntity<Void> deletaUsuario(@PathVariable Long idUsuario) {
        usuarioService.DelUsuario(idUsuario);
        return ResponseEntity.noContent().build();
    }
}
