package com.recuperacao.backend.Instantiation;


import com.recuperacao.backend.Model.*;
import com.recuperacao.backend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;


@Configuration
public class Instantiation implements CommandLineRunner {


    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    EditoraRepository editoraRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ExemplarRepository exemplarRepository;

    @Override
    public void run (String... args) throws Exception {

        Usuario usu1 = new Usuario(null, "Laura Ghellere", "14426978510", "32156992", "ReferenciaResidencial", "ReferenciaComercial", "lauragr@gmail.com", "991287775", true);
        Usuario usu2 = new Usuario(null, "Luisa Ghellere", "11586032909", "91804883", "ReferenciaResidencial", "ReferenciaComercial", "luisa@kionux.com", "991281754", true);
        usuarioRepository.saveAll(Arrays.asList(usu1, usu2));

        Autor aut1 = new Autor(null, "Cassandra Clare");
        Autor aut2 = new Autor(null, "John Green");
        autorRepository.saveAll(Arrays.asList(aut1, aut2));

        Editora edi1 = new Editora(null, "Galera Records");
        Editora edi2 = new Editora(null, "Intrínseca");
        editoraRepository.saveAll(Arrays.asList(edi1, edi2));

        Categoria cat1 = new Categoria(null, "Drama", 3);
        Categoria cat2 = new Categoria(null, "Romance", 5);
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));

        Livro liv1 = new Livro(null, "Cidade dos Ossos", aut1, edi1, cat2);
        Livro liv2 = new Livro(null, "Cidade de Vidro", aut1, edi1, cat2);
        Livro liv3 = new Livro(null, "Cidade dos Anjos Caidos", aut1, edi1, cat1);
        Livro liv4 = new Livro(null, "Looking for Alaska", aut2, edi2, cat1);
        Livro liv5 = new Livro(null, "Paper City", aut2, edi2, cat2);
        livroRepository.saveAll(Arrays.asList(liv1, liv2, liv3, liv4, liv5));

        Exemplar ex1 = new Exemplar(null, liv1 );
        exemplarRepository.saveAll(Arrays.asList(ex1));

        Emprestimo emp1 = new Emprestimo(null, true, LocalDate.now(), LocalDate.now().plusDays(liv1.getCategoria().getPrazoCategoria()), usu2, ex1);
        emprestimoRepository.saveAll(Arrays.asList(emp1));


    }






}





















