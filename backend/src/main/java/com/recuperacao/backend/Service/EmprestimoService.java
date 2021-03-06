package com.recuperacao.backend.Service;


import com.recuperacao.backend.Model.Livro;
import com.recuperacao.backend.Repository.EmprestimoRepository;
import com.recuperacao.backend.Repository.LivroRepository;
import com.recuperacao.backend.Model.Emprestimo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    LivroService livroService;

    public List<Emprestimo> listEmprestimo(){
        return emprestimoRepository.findAll();
    }

    public Emprestimo listEmpId(Long idEmprestimo){
        Optional<Emprestimo> idReturn = emprestimoRepository.findById(idEmprestimo);
        return idReturn.get();
    }

    public Emprestimo cadEmprestimo(Emprestimo emprestimo) {
        Livro livro = livroRepository.getById(emprestimo.getEmprestimo_exemplar().getLivro().getIdLivro());
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolcao(LocalDate.now().plusDays(livro.getCategoria().getPrazoCategoria()));
        return emprestimoRepository.save(emprestimo);
    }

    public void delEmprestimo(Long idEmprestimo){
        Emprestimo emprestimo = emprestimoRepository.getById(idEmprestimo);
        emprestimoRepository.deleteById(idEmprestimo);
    }




}
