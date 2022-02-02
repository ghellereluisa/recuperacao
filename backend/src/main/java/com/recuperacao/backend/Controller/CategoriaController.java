package com.recuperacao.backend.Controller;

import com.recuperacao.backend.Service.CategoriaService;
import com.recuperacao.backend.Model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listaCategoria() {
        return categoriaService.listCategoria();
    }

    @GetMapping(value = "/{idCategoria}")
    public ResponseEntity<Categoria> buscaCategoriaId(@PathVariable Long categoriasId) {
        Categoria idReturn = categoriaService.listCatId(categoriasId);
        return ResponseEntity.ok().body(idReturn);
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastraCategoria(@RequestBody Categoria categoria) {
        categoria = categoriaService.cadCategoria(categoria);
        return ResponseEntity.ok().body(categoria);
    }

    @PutMapping(value = "/{idCategoria}")
    public ResponseEntity<Categoria> alteraCategoria(@RequestBody Categoria categorias, @PathVariable Long categoriasId) {
        categorias = categoriaService.altCategoria(categoriasId, categorias);
        return ResponseEntity.ok().body(categorias);
    }

    @DeleteMapping(value = "/{idCategoria}")
    public ResponseEntity<Void> deletaCategoria(@PathVariable Long idCategoria) {
        categoriaService.delCategoria(idCategoria);
        return ResponseEntity.noContent().build();
    }
}

