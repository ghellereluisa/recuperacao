import { useCallback, useEffect, useState } from 'react';
import NavBar from '../Components/NavBar/NavBar';
import api from '../Service/api';


function Exemplar(){

    const [livros, setLivros] = useState([])
    const [livroEscolhido, setLivroEscolhido] = useState()
    const [exemplares, setExemplares] = useState([])


    const handleSubmit = useCallback(async(event)=> {
        await api.post('/exemplar', {
           livro: livros.find(livro => livro.idLivro === Number(livroEscolhido))
        })
        handleGetData()
        

        event.preventDefault();
    },[ livroEscolhido])

    const handleGetData = useCallback(async()=>{
        const { data:livroData } = await api.get('/livro')
        const { data:exemplarData } = await api.get('/exemplar')

        setLivros(livroData)
        setExemplares(exemplarData)
    },[])
        

    useEffect(()=>{
        handleGetData()
    },[handleGetData])

    return (
        <div>
            <NavBar/>
            <h1>exemplares</h1>
            {exemplares.length > 0 && exemplares.map(exemplar => (
              <div key={exemplar.idExemplar} style={{display:'flex'}}>
                  <strong >
                      identificação do livro: {exemplar.idExemplar}
                  </strong>
                <strong className='ml-4'>
                    nome do livro: {exemplar.livro.nomeLivro}
                </strong>
                    
              </div>
            ))}


            <form onSubmit={(event)=>handleSubmit(event)}>
            <select className="ml-4"onChange={(e) => setLivroEscolhido(e.target.value)} value={livroEscolhido}>
                    <option value='default'>nenhuma</option>
                    {livros.length > 0 &&livros?.map((livro) => (
                    <option key={livro.idLivro} value={livro.idLivro}>{livro.nomeLivro}
                    </option>
                    ))}
            </select>
            <button className="ml-4" type='submit'>Finalizar</button>
            </form>
            </div>

    )

}
export default Exemplar;