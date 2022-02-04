import api from '../../Service/api';
import { useState, useEffect, useCallback } from 'react';


function EditarLivro({id}) {
    useEffect(() => {
        async function getCategoria() {
          const response = await api.get('/categoria')
          SetCategoria(response.data)
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

      const [categoria, SetCategoria] = useState([]);
      const [editora, setEditora] = useState([]);
      const [autor, setAutor] = useState([]);
      const [categoriaUsada, setCategoriaUsada] = useState(null);
      const [editoraUsada, setEditoraUsada] = useState(null);
      const [autorUsado, setAutorUsado] = useState(null);
      
      const[nomeLivro, setNomeLivro] = useState("");;

      const EditarLivro = useCallback((e) => {
        
        const livro = {
            livroNome: nomeLivro,

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

        api.put(`/livro/${id}`, livro)    
    }, [id, nomeLivro, categoriaUsada, autorUsado, editoraUsada])

    return (
        <div>
            <h3 className='color-muted-pink'>Editar um Livro</h3>
            <form className='' Name='cria-livro-form' onSubmit={EditarLivro}>
                <input placeholder='nomeLivro' type={'text'} onChange={(e) => setNomeLivro(e.target.value)} />
                <div className='' Name='categoria-livro'>
                <select onChange={(e) => setCategoriaUsada(e.target.value)} value={categoriaUsada}>
                    <option value='default'>nenhuma</option>
                    {categoria?.map((cat) => (
                    <option key={cat.idCategoria} value={cat.idCategoria}>{cat.nomeCategoria}</option>
                    ))}
                </select>
                </div>
                <div className='' Name="editora">
                <select onChange={(e) => setEditoraUsada(e.target.value)} value={editoraUsada}>
                    <option value='default'>nenhuma</option>
                    {editora?.map((ed) => (
                    <option key={ed.idEditora} value={ed.idEditora}>{ed.nomeEditora}</option>
                    ))}
                </select>
                </div>
                <div className='' Name="autor">
                <select onChange={(e) => setAutorEscolhido(e.target.value)} value={autorUsado}>
                    <option value='default'>Nenhum</option>
                    {autor?.map((aut) => (
                    <option key={aut.idAutor} value={aut.idAutor}>{aut.nomeAutor}</option> 
                    ))}
                </select>
                </div>
                <button className='rounded-md, p-4rem, bg-primary-500 hover:bg-primary-600' type='submit'>concluir e terminar</button>
            </form>
        </div>
    )
}

export default EditarLivro;