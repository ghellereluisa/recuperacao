import api from '../api';
import { useEffect } from 'react';
import { useCallback, useState } from 'react/cjs/react.development';
import Navbar from '../Components/Navbar';
import CriaCategoria from '../Components/CriaCategoria';

function CriaLivro(){

    const [categoria, setCategoria] = useState([]);
    const [editora, setEditora] = useState([]);
    const [autor, setAutor] = useState([]);
    const [categoriaUsada, setCategoriaUsada] = useState(null);
    const [editoraUsada, setEditoraUsada] = useState(null);
    const [autorUsado, setAutorUsado] = useState(null);
    
    const[nomeLivro, setNomeLivro] = useState("");
    const [exemplar, setExemplares] = useState(null);

    const [modalCriaCategoria, setModalCriaCategoria] = useState(false);

    useEffect(() => {
        async function getCategoria() {
          const response = await api.get('/categoria')
          setCategoria(response.data)
        }
        getCategoria();
      }, [])
      
      useEffect(() => {
        async function getEditora() {
          const response = await api.get('/editora')
          setEditora(response.data);
        }
        getEditora();
      }, [])
      
      useEffect(() =>{
        async function getAutor() {
          const response = await api.get('/autor')
          setAutor(response.data)
        }
        getAutor();
      }, [])

      const CriaLivro = useCallback((e) => {
        
        const livro = {
            livroNome: nomeLivro,
            exemplar: exemplar,
            categoria: {
                idCategoria: categoriaUsada
            },
            autor: {
                idAutor: autorUsado
            },
            editora: {
                idEditora: editoraUsada
            }
        }

        api.post("/livro", livro)    
    }) 

    return (
      <div className='container-fluid mt-5 pt-5 text-center'>
        <h2 className='color-muted-pink'> Sistema Empilhados na Estante</h2>
        <h4 className='color-muted-pink'> Criar um Novo livro</h4>
          <div className='container d-flex justify-content-between mt-5 pt-5'>
            <Navbar />
          <div>
              <form className='' Name='cria-livro-form' onSubmit={CriaLivro}>
                  <input placeholder='nomeLivro' type={'text'} onChange={(e) => setNomeLivro(e.target.value)} />
                  <input placeholder='Exemplares' type={'number'} onChange={(e) => setExemplares(e.target.value)} />
                  <div className='' Name='categoria-livro'>
                    <select onChange={(e) => setCategoriaUsada(e.target.value)} value={categoriaUsada}>
                      <option value='default'>nenhuma</option>
                      {categoria?.map((cat) => (
                        <option key={cat.idCategoria} value={cat.idCategoria}>{cat.categoriaNome}</option>
                      ))}
                    </select>
                  </div>
                  <button type='button' onClick={(e) => setModalCriaCategoria(!modalCriaCategoria)}>Ou criar nova categoria</button>
                  <div className='' Name="editora">
                    <select onChange={(e) => setEditoraUsada(e.target.value)} value={editoraUsada}>
                      <option value='default'>nenhuma</option>
                      {editora?.map((ed) => (
                        <option key={ed.idEditora} value={ed.idEditora}>{ed.editoraNome}</option>
                      ))}
                    </select>
                  </div>
                  <div className='' Name="autor">
                    <select onChange={(e) => setAutorUsado(e.target.value)} value={autorUsado}>
                      <option value='default'>Nenhum</option>
                      {autor?.map((aut) => (
                        <option key={aut.idAutor} value={aut.idAutor}>{aut.autorNome}</option> 
                      ))}
                    </select>
                  </div>
                  <button type='submit'>Criar Livro</button>
              </form>

              {modalCriaCategoria ?
                <CriaCategoria />
               : 
                <div></div>
              }
          </div>
        </div>
      </div>
    )
}

export default CriaLivro;