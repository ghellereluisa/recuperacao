import { useCallback, useEffect, useState } from 'react';
import NavBar from '../Components/NavBar/NavBar';
import api from '../Service/api';


function Editora(){

  const [nomeEditora, setNomeEditora] = useState('')


  const handleSubmit = useCallback(async(event)=> {
    await api.post('/editora', {
        nomeEditora
    })
  event.preventDefault();
  },[nomeEditora])

  return (
    <div>
        <NavBar/>

        <div className="mt-4 ml-6">
            <h2> Cadastrar nova editora</h2>
            <form onSubmit={(event)=>handleSubmit(event)}>
                <input className="ml-4" name='nomeEditora' placeholder='Nome da editora' onChange={event=> setNomeEditora(event.target.value)}/>

                <button className="ml-4" type='submit'>Finalizar</button>
            </form>
        </div>
   </div>



  )

}

export default Editora;