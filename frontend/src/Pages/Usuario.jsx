import { useCallback, useEffect, useState } from "react";
import NavBar from "../Components/NavBar/NavBar";
import api from "../Service/api";

function Usuario() {
  const [nomeUsuario, setNomeUsuario] = useState("");
  const [cpfUsuario, setCpfUsuario] = useState("");
  const [rgUsuario, setRgUsuario] = useState("");
  const [refEnderecoRes, setRefEnderecoRes] = useState("");
  const [emailUsuario, setEmailUsuario] = useState("");
  const [telefoneUsuario, setTelefoneUsuario] = useState("");
  const [admin, setAdmin] = useState(true);

  const handleSubmit = useCallback(
    async (event) => {
      await api.post("/usuario", {
        nomeUsuario,
        cpfUsuario,
        rgUsuario,
        refEnderecoRes: `viacep.com.br/ws/${refEnderecoRes}/json/`,
        emailUsuario,
        telefoneUsuario,
        admin,
      });
      event.preventDefault();
    },
    [
      nomeUsuario,
      cpfUsuario,
      rgUsuario,
      refEnderecoRes,
      emailUsuario,
      telefoneUsuario,
      admin,
    ]
  );

  return (
    <div>
      <NavBar />
      <h2> Cadastrar novo Livro</h2>
      <form onSubmit={(event) => handleSubmit(event)}>
        <input
          className="ml-4"
          name="nomeUsuario"
          placeholder="Nome do usuario"
          onChange={(event) => setNomeUsuario(event.target.value)}
        />
        <input
          className="ml-4"
          name="cpfUsuario"
          placeholder="cpf do usuario"
          onChange={(event) => setCpfUsuario(event.target.value)}
        />
        <input
          className="ml-4"
          name="rgUsuario"
          placeholder="rg do usuario"
          onChange={(event) => setRgUsuario(event.target.value)}
        />
        <input
          className="ml-4"
          name="refEnderecoRes"
          placeholder="cep endereço residencial"
          onChange={(event) => setRefEnderecoRes(event.target.value)}
        />
        <input
          className="ml-4"
          name="emailUsuario"
          placeholder="email do usuario"
          onChange={(event) => setEmailUsuario(event.target.value)}
        />
        <input
          className="ml-4"
          name="telefoneUsuario"
          placeholder="telefone do usuario"
          onChange={(event) => setTelefoneUsuario(event.target.value)}
        />
        <div>
          <input type="radio" id="contactChoice1" name="isADmin" value="true">
            <label for="contactChoice1">sim</label>
          </input>

          <input type="radio" id="contactChoice2" name="isAdmin" value="false">
            <label for="contactChoice2">não</label>
          </input>
        </div>
      </form>
    </div>
  );
}
