import React, { useState } from "react";

import Header from "../components/Header";
import DataTableLivro from "../components/DataTableLivro";
import ModalLivro from "../components/ModalLivro";
import * as C from "../styles/style";

function Livro() {
  const [showModal, setShowModal] = useState(false);
  const closeModal = () => setShowModal(false);

  return (
    <>
      
        <Header>
          <h2 className="text-center ,bg-primary">Empilhados na estante</h2>
          <button onClick={() => setShowModal(true)}>Cadastrar Livro</button>
        </Header>
       
    </>
  );
}

export default Livro;
