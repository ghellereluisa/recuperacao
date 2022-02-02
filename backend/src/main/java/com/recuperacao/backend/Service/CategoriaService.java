package com.recuperacao.backend.Service;

import com.recuperacao.backend.Repository.CategoriaRepository;
import com.recuperacao.backend.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> listCategoria(){
     return categoriaRepository.findAll();
    }

    public Categoria listCatId(Long idCategoria){
        Optional<Categoria> idReturn = categoriaRepository.findById(idCategoria)
        return idReturn.get();
    }

    public Categoria cadCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public void delCategoria(Long idCategoria){
        categoriaRepository.deleteById(idCategoria);
    }

    public Categoria altCategoria(Long idCategoria, Categoria idReturn){
        Categoria entCat = categoriaRepository.findById(idCategoria).get();
        UpdateInfo(entCat, idReturn);
        return categoriaRepository.save(entCat);
    }

    public void UpdateInfo(Categoria entCat, Categoria idReturn){
        entCat.setNomeCategoria(idReturn.getNomeCategoria());
        entCat.setPrazoCategoria(idReturn.getPrazoCategoria());
    }

}
