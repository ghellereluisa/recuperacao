import { useCallback, useEffect, useState } from "react";
import NavBar from "../Components/NavBar/NavBar";
import api from "../Service/api";

function App() {
  const [livros, setLivros] = useState([]);

  const handleGetData = useCallback(async () => {
    const { data } = await api.get("/livro");
    setLivros(data);
  }, []);

  useEffect(() => {
    handleGetData();
  }, [handleGetData]);

  return (
    <div>
      <NavBar />
      <h1>Bem vindos ao Empilhados na Estante</h1>
      {livros.length > 0 &&
        livros.map((livro) => (
          <div key={livro.idLivro} style={{ display: "flex" }}>
            <strong>{livro.nomeLivro}</strong>

            <div style={{ display: "flex" }}>
              <button>
                <a href={`/livro/${livro.idLivro}`}>Detalhes</a>
              </button>
            </div>
          </div>
        ))}
    </div>
  );
}

export default App;
