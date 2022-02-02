package com.recuperacao.backend.Service;


import com.recuperacao.backend.Repository.LivroRepository;
import com.recuperacao.backend.model.Exemplar;
import com.recuperacao.backend.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    public List<Livro> listLivro(){
        return livroRepository.findAll();
    }

    public Livro listLivroId(Long idLivro){
        Optional<Livro> idReturn = livroRepository.findById(idLivro);
        return idReturn.get();
    }

    public Livro cadLivro(Livro livro){
        return livroRepository.save(livro);
    }

    public void delLivro(Long idLivro){
        livroRepository.deleteById(idLivro);
    }

    public Livro altLivro(Long idLivro, Livro idReturn){
        Livro livEnt = livroRepository.findById(idLivro).get();
        UpdateInfo(livEnt, idReturn);
        return livroRepository.save(livEnt);
    }

    private void UpdateInfo(Livro livEnt, Livro idReturn){
        livEnt.setAutor(idReturn.getAutor());
        livEnt.setCategoriaLivros(idReturn.getCategoriaLivros());
        livEnt.setEditora(idReturn.getEditora());
        livEnt.setNomeLivro(idReturn.getNomeLivro());
    }

}
