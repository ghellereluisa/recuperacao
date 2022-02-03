package com.recuperacao.backend;


import com.recuperacao.backend.Creator.*;
import com.recuperacao.backend.Model.*;
import com.recuperacao.backend.Repository.*;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Log4j2
class TesteIntegracao {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ExemplarRepository exemplarRepository;

    @Autowired
    EditoraRepository editoraRepository;

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @BeforeEach
    void setup(){
        livroRepository.save(LivroCreator.livroCreate());
        autorRepository.save(AutorCreator.autorCreate());
        editoraRepository.save(EditoraCreator.editoraCreate());
        categoriaRepository.save(CategoriaCreator.categoriaCreate());
        usuarioRepository.save(UsuarioCreator.usuarioCreate());
        emprestimoRepository.save(EmprestimoCreator.emprestimoCreate());
        exemplarRepository.saveAll(ExemplarCreator.exemplarListaCreate());
        exemplarRepository.save(ExemplarCreator.exemplarCreate());

    }


    /*TESTE EXEMPLARES*/
    @Test
    void ReturnExemplarLista_RetornarSucesso(){

        ResponseEntity<Exemplar[]> resp =
                this.testRestTemplate.getForEntity("http://localhost:" + port + "/exemplar", Exemplar[].class);
        Exemplar[] exemplar = resp.getBody();

        System.out.print("teste" + exemplar);

        assertAll(() -> assertNotNull(exemplar), () -> assertEquals(4, exemplar.length));
    }

    /*TESTE EMPRESTIMO*/
    @Test
    void DataDev_MaiorDataEmp_RetornarSucesso(){
        ResponseEntity<Emprestimo> resp =
                this.testRestTemplate.getForEntity("http://localhost:" + port + "/emprestimo/1", Emprestimo.class);
        Emprestimo respEmprestimo = resp.getBody();
        System.out.print("teste" + respEmprestimo);
        Assertions.assertThat(respEmprestimo).isNotNull();
        Assertions.assertThat(respEmprestimo.getDataDevolcao()).isEqualTo(LocalDate.now().plusDays(3));
    }

    /*TESTE LIVRO*/
    @Test
    void BuscaLivro_RetornaSucesso(){
        ResponseEntity<Livro> resp=
                this.testRestTemplate.getForEntity("http://localhost:" + port + "/livro/1", Livro.class);
        Livro respLivro = resp.getBody();
        System.out.print("teste" + respLivro);
        Assertions.assertThat(respLivro).isNotNull();
    }

    /*TESTE CATEGORIA*/
    @Test
    void BuscaCategoria_RetornaSucesso(){
        ResponseEntity<Categoria> resp=
                this.testRestTemplate.getForEntity("http://localhost:" + port + "/categoria/1", Categoria.class);
        Categoria respCat = resp.getBody();
        System.out.print("teste" + respCat);
        Assertions.assertThat(respCat).isNotNull();
    }

    /*TESTE AUTOR*/
    @Test
    void DeletarAutor_RetornaSucesso(){
        Long id = 1L;
        this.testRestTemplate.delete("http://localhost:" + port + "/autor/", id);
    }

    /*TESTE USUARIO*/
    @Test
    void CriaUsuario_RetornaSucesso(){
        Usuario usu1 = new Usuario(null, "nome", "cpf", "rg", "end", "end", "email", "tel", true);
        ResponseEntity<Usuario> resp =
                this.testRestTemplate.postForEntity("http://localhost:" + port + "/usuario", usu1, Usuario.class);
        Assertions.assertThat(resp.getBody()).isNotNull();
        Assertions.assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    /*TESTE EDITORA*/

    @Test
    void AlterarEdt_RetornaSucesso(){
        Optional<Editora> respEditora = editoraRepository.findById(1L);
        Editora editora = new Editora(1L, "editora");
        this.testRestTemplate.put("http://localhost:" + port + "/editora/" + 1L, editora);
        Assertions.assertThat(respEditora.get().getNomeEditora()).isNotEqualTo(editora.getNomeEditora());
    }

}
