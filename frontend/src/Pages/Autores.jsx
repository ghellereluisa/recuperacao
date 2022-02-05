import { useCallback, useEffect, useState } from "react";
import NavBar from "../Components/NavBar/NavBar";
import api from "../Service/api";

function Autores() {
  const [nomeAutor, setNomeAutor] = useState("");

  const handleSubmit = useCallback(
    async (event) => {
      await api.post("/autores", {
        nomeAutor,
      });
      event.preventDefault();
    },
    [nomeAutor]
  );

  return (
    <div>
      <NavBar />

      <div className="mt-4 ml-6">
        <h2> Cadastrar novo Autor</h2>
        <form onSubmit={(event) => handleSubmit(event)}>
          <input
            className="ml-4"
            name="nomeAutor"
            placeholder="Nome do autor"
            onChange={(event) => setNomeAutor(event.target.value)}
          />

          <button className="ml-4" type="submit">
            Finalizar
          </button>
        </form>
      </div>
    </div>
  );
}

export default Autores;
