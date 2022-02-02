package com.recuperacao.backend.Controller;

import com.recuperacao.backend.Service.LivroService;
import com.recuperacao.backend.Model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    LivroService livroService;

    @GetMapping
    public List<Livro> listLivro() {
        return livroService.listLivro();
    }

    @GetMapping(value = "/{idLivro}")
    public ResponseEntity<Livro> buscaLivroId(@PathVariable Long idLivro) {
        Livro idReturn = livroService.listLivroId(idLivro);
        return ResponseEntity.ok().body(idReturn);
    }

    @PostMapping
    public ResponseEntity<Livro> cadastraLivro(@RequestBody Livro livro) {
        livro = livroService.cadLivro(livro);
        return ResponseEntity.ok().body(livro);
    }

    @PutMapping(value = "/{idLivro}")
    public ResponseEntity<Livro> alterarLivro(@RequestBody Livro livro, @PathVariable Long idLivro) {
        livro = livroService.altLivro(idLivro, livro);
        return ResponseEntity.ok().body(livro);
    }

    @DeleteMapping(value = "/{idLivro}")
    public ResponseEntity<Void> apagaLivro(@PathVariable Long idLivro) {
        livroService.delLivro(idLivro);
        return ResponseEntity.noContent().build();
    }

}
