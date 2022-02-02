package com.recuperacao.backend.Controller;

import com.recuperacao.backend.Service.EditoraService;
import com.recuperacao.backend.Model.Editora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/editora")
public class EditoraController {

    @Autowired
    EditoraService editoraService;

    @GetMapping
    public List<Editora> listaEditoras() {
        return editoraService.listEditora();
    }

    @GetMapping(value = "/{idEditora}")
    public ResponseEntity<Editora> listaEditorasById(@PathVariable Long idEditora) {
        Editora idReturn = editoraService.listEditoraId(idEditora);
        return ResponseEntity.ok().body(idReturn);
    }

    @PostMapping
    public ResponseEntity<Editora> cadastraEditora(@RequestBody Editora editora) {
        editora = editoraService.cadEditora(editora);
        return ResponseEntity.ok().body(editora);
    }

    @PutMapping(value = "/{idEditora}")
    public ResponseEntity<Editora> alteraEditoras(@PathVariable Long idEditora, @RequestBody Editora editora) {
        editora = editoraService.altEditora(idEditora, editora);
        return ResponseEntity.ok().body(editora);
    }

    @DeleteMapping(value = "/{idEditora}")
    public ResponseEntity<Void> deletaEditoras(@PathVariable Long idEditora) {
        editoraService.delEditora(idEditora);
        return ResponseEntity.noContent().build();
    }
}
