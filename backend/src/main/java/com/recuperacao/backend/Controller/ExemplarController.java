package com.recuperacao.backend.Controller;


import com.recuperacao.backend.Model.Exemplar;
import com.recuperacao.backend.Model.Livro;
import com.recuperacao.backend.Service.ExemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/exemplar")
public class ExemplarController {
    @Autowired
    ExemplarService exemplarService;

    @GetMapping
    public List<Exemplar> listExemplar(){
        return exemplarService.listExemplar();
    }

    @GetMapping(value = "/{idExemplar}")
    public ResponseEntity<Exemplar> buscaExemplarId(@PathVariable Long idExemplar){
        Exemplar idReturn = exemplarService.listExemplarId(idExemplar);
        return ResponseEntity.ok().body(idReturn);
    }

    @PostMapping
    public ResponseEntity<Exemplar> cadastraExemplar(@RequestBody Exemplar exemplar) {
        exemplar = exemplarService.cadExemplar(exemplar);
        return ResponseEntity.ok().body(exemplar);
    }

    @PutMapping(value = "/{idExemplar}")
    public ResponseEntity<Exemplar> alterarExemplar(@RequestBody Exemplar exemplar, @PathVariable Long idExemplar) {
        exemplar = exemplarService.altExemplar(idExemplar, exemplar);
        return ResponseEntity.ok().body(exemplar);
    }

    @DeleteMapping(value = "/{idExemplar}")
    public ResponseEntity<Void> apagaExempar(@PathVariable Long idExemplar) {
        exemplarService.delExemplar(idExemplar);
        return ResponseEntity.noContent().build();
    }
}
