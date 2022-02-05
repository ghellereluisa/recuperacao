import { useCallback, useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import api from "../Service/api";

const Livro = () => {
  const { id } = useParams();

  const [livro, setLivro] = useState(null);
  const [isUpdate, setIsUpdate] = useState(false);

  const [nomeLivro, setNomeLivro] = useState("");
  const [categoriaEscolhida, setCategoriaEscolhida] = useState();
  const [categorias, setCategorias] = useState([]);
  const [editoraEscolhida, setEditoraEscolhida] = useState();
  const [editoras, setEditoras] = useState([]);
  const [autorEscolhido, setAutorEscolhido] = useState();
  const [autores, setAutores] = useState([]);

  const handleGetBook = useCallback(async () => {
    const { data } = await api.get(`/livro/${id}`);

    setLivro(data);
  }, []);

  const handleGetData = useCallback(async () => {
    const { data: categoriaData } = await api.get("/categoria");
    const { data: editoraData } = await api.get("/editora");
    const { data: autorData } = await api.get("/autores");

    setCategorias(categoriaData);
    setEditoras(editoraData);
    setAutores(autorData);
  }, []);

  useEffect(() => {
    if (livro) {
      setNomeLivro(livro.nomeLivro);
      setCategoriaEscolhida(livro.categoria.idCategoria);
      setAutorEscolhido(livro.autor.idAutor);
      setEditoraEscolhida(livro.editora.idEditora);
    }
  }, [livro, categorias]);

  useEffect(() => {
    handleGetData();
  }, [handleGetData]);

  useEffect(() => {
    handleGetBook();
  }, [handleGetBook]);

  const handleSubmit = useCallback(
    async (event) => {
      await api.put(`/livro/${livro.idLivro}`, {
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

      handleGetData();

      setIsUpdate(false);

      event.preventDefault();
    },
    [nomeLivro, categoriaEscolhida, editoraEscolhida, autorEscolhido]
  );

  const handleRemove = useCallback(async (livroData) => {
    await api.delete(`/livro/${livroData.idLivro}`);

    window.location.pathname = "/";
  }, []);

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        width: "100%",
      }}
    >
      {livro && (
        <>
          <h3>{livro.nomeLivro}</h3>
          <p>{livro.categoria.nomeCategoria}</p>
          <p>{livro.editora.nomeEditora}</p>
          <p>{livro.autor.nomeAutor}</p>

          <button onClick={() => setIsUpdate(true)}>Editar livro</button>
          <button onClick={() => handleRemove(livro)}>Remover</button>
        </>
      )}
      {isUpdate && livro && (
        <div className="mt-4 ml-6">
          <h2> Editar livro {livro && livro.idLivro} </h2>
          <form onSubmit={(event) => handleSubmit(event)}>
            <input
              className="ml-4"
              value={nomeLivro}
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
              Atualizar
            </button>
          </form>
        </div>
      )}
    </div>
  );
};

export default Livro;
