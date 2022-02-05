import { useCallback, useEffect, useState } from "react";
import NavBar from "../Components/NavBar/NavBar";
import api from "../Service/api";

function Livro() {
  const [nomeLivro, setNomeLivro] = useState("");
  const [categoriaEscolhida, setCategoriaEscolhida] = useState();
  const [categorias, setCategorias] = useState([]);
  const [editoraEscolhida, setEditoraEscolhida] = useState();
  const [editoras, setEditoras] = useState([]);
  const [autorEscolhido, setAutorEscolhido] = useState();
  const [autores, setAutores] = useState([]);

  const handleSubmit = useCallback(
    async (event) => {
      await api.post("/livro", {
        nomeLivro,
        autor: autores.find(
          (autor) => autor.idAutor === Number(autorEscolhido)
        ),
        editora: editoras.find(
          (editora) => editora.idEditora === Number(editoraEscolhida)
        ),
        categoria: categorias.find(
          (categoria) => categoria.idCategoria === Number(categoriaEscolhida)
        ),
      });

      console.log("Thats ok!");

      event.preventDefault();
    },
    [nomeLivro, categoriaEscolhida, editoraEscolhida, autorEscolhido]
  );

  const handleGetData = useCallback(async () => {
    const { data: categoriaData } = await api.get("/categoria");
    const { data: editoraData } = await api.get("/editora");
    const { data: autorData } = await api.get("/autores");

    setCategorias(categoriaData);
    setEditoras(editoraData);
    setAutores(autorData);
  }, []);

  useEffect(() => {
    handleGetData();
  }, [handleGetData]);

  return (
    <div>
      <NavBar />

      <div className="mt-4 ml-6">
        <h2> Cadastrar novo Livro</h2>
        <form onSubmit={(event) => handleSubmit(event)}>
          <input
            className="ml-4"
            name="nomeLivro"
            placeholder="Nome do livro"
            onChange={(event) => setNomeLivro(event.target.value)}
          />

          <select
            className="ml-4"
            onChange={(e) => setCategoriaEscolhida(e.target.value)}
            value={categoriaEscolhida}
          >
            <option value="default">nenhuma</option>
            {categorias.length > 0 &&
              categorias?.map((categoria) => (
                <option
                  key={categoria.idCategoria}
                  value={categoria.idCategoria}
                >
                  {categoria.nomeCategoria}
                </option>
              ))}
          </select>

          <select
            className="ml-4"
            onChange={(e) => setEditoraEscolhida(e.target.value)}
            value={editoraEscolhida}
          >
            <option value="default">nenhuma</option>
            {editoras.length > 0 &&
              editoras?.map((editora) => (
                <option key={editora.idEditora} value={editora.idEditora}>
                  {editora.nomeEditora}
                </option>
              ))}
          </select>

          <select
            className="ml-4"
            onChange={(e) => setAutorEscolhido(e.target.value)}
            value={autorEscolhido}
          >
            <option value="default">nenhuma</option>
            {autores.length > 0 &&
              autores?.map((autor) => (
                <option key={autor.idAutor} value={autor.idAutor}>
                  {autor.nomeAutor}
                </option>
              ))}
          </select>

          <button className="ml-4" type="submit">
            Finalizar
          </button>
        </form>
      </div>
    </div>
  );
}

export default Livro;
