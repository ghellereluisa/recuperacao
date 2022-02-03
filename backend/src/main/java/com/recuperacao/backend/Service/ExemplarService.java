package com.recuperacao.backend.Service;

import com.recuperacao.backend.Model.Exemplar;
import com.recuperacao.backend.Model.Livro;
import com.recuperacao.backend.Repository.ExemplarRepository;
import com.recuperacao.backend.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ExemplarService {

    @Autowired
    ExemplarRepository exemplarRepository;

    public List<Exemplar> listExemplar(){
        return exemplarRepository.findAll();
    }

    public Exemplar listExemplarId(Long idExemplar){
        Optional<Exemplar> idReturn = exemplarRepository.findById(idExemplar);
        return idReturn.get();
    }

    public Exemplar cadExemplar(Exemplar exemplar){
        return exemplarRepository.save(exemplar);
    }

    public void delExemplar(Long idExemplar){
        exemplarRepository.deleteById(idExemplar);
    }

    public Exemplar altExemplar(Long idExemplar, Exemplar idReturn){
        Exemplar exEnt = exemplarRepository.findById(idExemplar).get();
        UpdateInfo(exEnt, idReturn);
        return exemplarRepository.save(exEnt);
    }

    public void UpdateInfo(Exemplar exEnt, Exemplar idReturn){
        exEnt.setLivro(idReturn.getLivro());
    }

}


