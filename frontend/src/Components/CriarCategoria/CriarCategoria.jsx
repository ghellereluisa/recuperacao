import { useState } from "react";
import api from "../api";



function CriarNovaCategoria() {

    const [nomeCat, setNomeCat] = useState("");
    const [prazoCategoria, setPrazoCategoria] = useState(null);

    const CriaCat = () => {
        const categoria = {
            categoriaNome: nomeCategoria,
            prazoCategoria: prazoCategoria
        }

        api.post("/categoria", categoria);

    }

    return(
        <div>
            <h3 className='color-muted-pink'>Criar uma Categoria</h3>
            <form className='' name='criar-nova-categoria' onSubmit={CriaCat}>
                <input placeholder="digite o nome da Categoria" type={'text'} onChange={(e) => setNomeCat(e.target.value)}/>
                <input placeholder="digite a quantidade de dias do emprestimo" type={'number'} onChange={(e) => setPrazoCategoria(e.target.value)}/>
                <button className='rounded-md, p-4rem, bg-primary-500 hover:bg-primary-600' type='submit'>concluir e terminar</button>
            </form>
        </div>
    )
}

export default CriarNovaCategoria;