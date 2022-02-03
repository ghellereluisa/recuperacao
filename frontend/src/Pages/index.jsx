import NavBar from "../Components/NavBar";
import { useEffect, useState } from "react";
import api from '../api';
import EditarLivro from '../Components/EditarLivro';
import { Link } from "react-router-dom";


function App() {

  const [livro, SetLivro] = useState([]);
  const [categoria, SetCategoria] = useState([]);
  const [editora, setEditora] = useState([]);
  const [autor, setAutor] = useState([]);
  const [categoriaUsada, setCategoriaUsada] = useState(null);
  const [editoraUsada, setEditoraUsada] = useState(null);
  const [autorUsado, setAutorUsado] = useState(null);
  const [idLivro, setIdLivro] = useState(null);

  const [showEditarLivro, setShowEditarLivro] = useState(false);

  useEffect(() => {
    async function getLivro() {
        const response = await api.get('/livro')
        console.log(response);
        SetLivro(response.data);
    }
    getLivro();
}, [])

useEffect(() => {
  async function getCategoria() {
    const response = await api.get('/categoria')
    console.log("categoria: ", response);
    SetCategoria(response.data)
  }
  getCategoria();
}, [])

useEffect(() => {
  async function getEditora() {
    const response = await api.get('/editora')
    console.log("editora", response)
    setEditora(response.data);
  }
  getEditora();
}, [])

useEffect(() =>{
  async function getAutor() {
    const response = await api.get('/autor')
    console.log("autor: ", response)
    setAutor(response.data)
  }
  getAutor();
}, [])



  async function delLivro() {
    const resp = await api.delete(`/livro/${idLivro}`)
    window.location.reload()

  }

  return (
    <div className="container-fluid mt-5 pt-3 text-center">
      <h2>Sistema Bibliotecário</h2>
      <div className="container d-flex justify-content-between mt-5 pt-3">
        <NavBar />
        <div>
          <div className='' Name="filters">
            <h5>Filtrar livro por: </h5>
            <div className='' Name="filters-select">
              <div className='' Name="categoria">
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
                  <select onChange={(e) => setAutorUsado(e.target.value)} value={autorUsado}>
                    <option value='default'>Nenhum</option>
                    {autor?.map((aut) => (
                      <option key={aut.idAutor} value={aut.idAutor}>{aut.nomeAutor}</option> 
                    ))}
                  </select>
              </div>
              <Link to="/criaLivro">
                <button className='rounded-md, p-4rem, bg-primary-500 hover:bg-primary-600'>Criar Novo Livro</button>
              </Link>
            </div>
          </div>

          {livro.map(livro => 
            <div className='' Name="div-livro" key={livro.livroId}>
              <div className='' Name="div-livro-header">
                <h2>{livro.livroNome}</h2>
                <div className='' Name="div-livro-header-buttons">
                  <button className='rounded-md, p-4rem, bg-primary-500 hover:bg-primary-600' Name="editar" onClick={() => {
                    setIdLivro(livro.livroId);
                    setShowEditarLivro(!showEditarLivro)
                  }}>Editar</button>
                  <button className='rounded-md, p-4rem, bg-primary-500 hover:bg-primary-600' Name="excluir"
                    onClick={() => {
                      setIdLivro(livro.livroId);
                      delLivro();
                    }}
                  >Excluir</button>
                </div>
              </div>
              <div className='' Name="livro-data">
                <div className='' Name="livro-data-text">
                  <span><b>Categoria: </b>{livro.categoria.nomeCategoria}</span>
                  <span><b>Editora: </b>{livro.editora.nomeEditora}</span>
                  <span><b>Autor: </b>{livro.autor.nomeAutor}</span>
                </div>
                <div className='' Name="livro-data-qtt">
                  <span><b>Quantidade: </b>{livro.exemplar}</span>
                </div>
              </div>
            </div>
          )}
          {showEditarLivro && idLivro &&
            <EditarLivro id={idLivro} />
          }
        </div>
      </div>
    </div>
  );
}

export default App;
