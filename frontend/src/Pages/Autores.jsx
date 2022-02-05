import { useCallback, useEffect, useState } from 'react';
import NavBar from '../Components/NavBar/NavBar';
import api from '../Service/api';

function Autores(){


    
  return (
    <div>
        <NavBar/>

        <div className="mt-4 ml-6">
            <h2> Cadastrar novo Livro</h2>
            <form onSubmit={(event)=>handleSubmit(event)}>
                <input className="ml-4" name='nomeLivro' placeholder='Nome do livro' onChange={event=> setNomeLivro(event.target.value)}/>

                <select className="ml-4"onChange={(e) => setCategoriaEscolhida(e.target.value)} value={categoriaEscolhida}>
                      <option value='default'>nenhuma</option>
                      {categorias.length > 0 &&categorias?.map((categoria) => (
                        <option key={categoria.idCategoria} value={categoria.idCategoria}>{categoria.nomeCategoria}</option>
                      ))}
                </select>

                <select className="ml-4"onChange={(e) => setEditoraEscolhida(e.target.value)} value={editoraEscolhida}>
                      <option value='default'>nenhuma</option>
                      {editoras.length > 0 &&editoras?.map((editora) => (
                        <option key={editora.idEditora} value={editora.idEditora}>{editora.nomeEditora}</option>
                      ))}
                </select>

                <select className="ml-4"onChange={(e) => setAutorEscolhido(e.target.value)} value={autorEscolhido}>
                      <option value='default'>nenhuma</option>
                      {autores.length > 0 &&autores?.map((autor) => (
                        <option key={autor.idAutor} value={autor.idAutor}>{autor.nomeAutor}</option>
                      ))}
                </select>


                <button className="ml-4" type='submit'>Finalizar</button>
            </form>
        </div>


        <div className="mt-4 ml-6">
            <h2> Consultar Livro</h2>

        </div>

        
        <div className="mt-4 ml-6">
            <h2> Editar um Livro</h2>

        </div>

        <div className="mt-4 ml-6">
            <h2> Deletar um Livro</h2>

        </div>
   </div>
   
  )
}


export default Autores;