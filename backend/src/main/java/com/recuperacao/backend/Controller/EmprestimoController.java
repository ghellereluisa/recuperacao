package com.recuperacao.backend.Controller;

import com.recuperacao.backend.Service.EmprestimoService;
import com.recuperacao.backend.Model.Emprestimo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    EmprestimoService emprestimoService;

    @GetMapping
    public List<Emprestimo> listaEmprestimo() {
        return emprestimoService.listEmprestimo();
    }

    @GetMapping(value = "/{idEmprestimo}")
    public ResponseEntity<Emprestimo> BuscaEmprestimoId(@PathVariable Long idEmprestimo) {
        Emprestimo obj = emprestimoService.listEmpId(idEmprestimo);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Emprestimo> cadastraEmprestimo(@RequestBody Emprestimo emprestimo) {
        emprestimo = emprestimoService.cadEmprestimo(emprestimo);
        return ResponseEntity.ok().body(emprestimo);
    }

    @DeleteMapping(value = "/{idEmprestimo}")
    public ResponseEntity<Void> deletaEmprestimo(@PathVariable Long idEmprestimo) {
        emprestimoService.delEmprestimo(idEmprestimo);
        return ResponseEntity.noContent().build();
    }
}
