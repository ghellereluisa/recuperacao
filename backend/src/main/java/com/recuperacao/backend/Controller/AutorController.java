package com.recuperacao.backend.Controller;

import com.recuperacao.backend.Service.AutorService;
import com.recuperacao.backend.Model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorService autorService;

    @GetMapping
    public List<Autor> listaAutores() {
        return autorService.listAutores();
    }

    @GetMapping(value = "/{idAutor}")
    public ResponseEntity<Autor> buscaAutorPorId(@PathVariable Long idAutor) {
        Autor obj = autorService.ListAutorId(idAutor);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Autor> cadastrarAutor(@RequestBody Autor autor) {
        autor = autorService.CadAutor(autor);
        return ResponseEntity.ok().body(autor);
    }

    @PutMapping(value = "/{idAutor}")
    public ResponseEntity<Autor> alteraAutor(@RequestBody Autor autor, @PathVariable Long idAutor) {
        autor = autorService.AltAutor(idAutor, autor);
        return ResponseEntity.ok().body(autor);
    }


    @DeleteMapping(value = "/{idAutor}")
    public ResponseEntity<Void> deletaAutor(@PathVariable Long idAutor) {
        autorService.DelAutor(idAutor);
        return ResponseEntity.noContent().build();
    }

}
