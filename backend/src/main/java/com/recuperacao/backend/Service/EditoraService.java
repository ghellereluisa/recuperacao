package com.recuperacao.backend.Service;

import com.recuperacao.backend.Repository.EditoraRepository;
import com.recuperacao.backend.Model.Editora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {

    @Autowired
    EditoraRepository editoraRepository;

    public List<Editora> listEditora(){
        return editoraRepository.findAll();
    }

    public Editora listEditoraId(Long idEditora){
        Optional<Editora> idReturn = editoraRepository.findById(idEditora);
        return idReturn.get();
    }

    public Editora cadEditora(Editora editora){
        return editoraRepository.save(editora);
    }

    public void delEditora(Long idEditora){
        editoraRepository.deleteById(idEditora);
    }

    public Editora altEditora(Long idEditora, Editora idReturn){
        Editora entEditora = editoraRepository.findById(idEditora).get();
        UpdateInfo(entEditora, idReturn);
        return editoraRepository.save(entEditora);
    }

    public void UpdateInfo(Editora entEditora, Editora idReturn){
        entEditora.setNomeEditora(idReturn.getNomeEditora());
    }

}
