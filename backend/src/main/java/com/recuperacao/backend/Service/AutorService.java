package com.recuperacao.backend.Service;

import com.recuperacao.backend.Repository.AutorRepository;
import com.recuperacao.backend.Model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    public List<Autor> listAutores(){
        return autorRepository.findAll();
    }

    public Autor ListAutorId(Long idAutor){
        Optional<Autor> idReturn = autorRepository.findById(idAutor);
        return idReturn.get();
    }

    public Autor CadAutor(Autor autor){
        return autorRepository.save(autor);
    }

    public void DelAutor(Long idAutor){
        autorRepository.deleteById(idAutor);
    }

    public Autor AltAutor(Long idAutor, Autor idReturn){
        Autor entAutor = autorRepository.findById(idAutor).get();
        UpdateInfo(entAutor, idReturn);
        return autorRepository.save(entAutor);
    }

    private void UpdateInfo(Autor entity, Autor idReturn){
        entity.setNomeAutor(idReturn.getNomeAutor());
    }
}
