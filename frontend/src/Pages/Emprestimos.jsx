import { useState, useEffect } from 'react/cjs/react.development';
import NavBar from '../Components/NavBar';
import api from '../api';
import CriaEmprestimo from '../Components/CriaEmprestimo';


function Emprestimo(){

    const [emprestimo, setEmprestimo] = useState([])
    const [showModal, setShowModal] = useState([false])
    const [idEmprestimo, setIdEmprestimo] = useState(null);

    useEffect(() => {
        async function getEmprestimo() {
            const response = await api.get('/emprestimo')
            console.log(response);
            setEmprestimo(response.data);
        }
        getEmprestimo();
    }, [])

    async function delEmprestimo() {
        const resp = await api.delete(`/emprestimo/${idEmprestimo}`)
        window.location.reload();
    }

    const data = new Date();
    const dia = String(data.getDate());
    const mes = String(data.getMonth() + 1);
    const ano = data.getFullYear();
    const datafinal = String.valueOf(dia).concat("/").concat(String.valueOf(mes)).concat("/").concat(String.valueOf(ano));
    System.out.println("data: "+datafinal);
    console.log(dataAtual);

    
    
    return(
        <div className="container-fluid mt-5 pt-3 text-center">
            <h2 className='color-muted-pink'> Sistema Empilhados na Estante</h2>
            <h4 className='color-muted-pink'>Emprestimo</h4>
            <div className="container d-flex justify-content-between mt-5 pt-3">
                <NavBar />
                <div>
                    <button className='rounded-md, p-4rem, bg-primary-500 hover:bg-primary-600' onClick={() => setShowModal(!showModal)}>Cadastrar Novo Emprestimo</button>
                    {emprestimo.map(emp =>
                    <div className='div-emprestimo' key={emp.idEmprestimo}>
                        <button className='rounded-md, p-4rem, bg-primary-500 hover:bg-primary-600' Name='excluir' onClick={() => {
                            setIdEmprestimo(emp.idEmprestimo);
                            delEmprestimo();
                        }}>Excluir</button>
                        <h2>{emp.usuario.nomeUsuario}</h2>
                        <span><b>Livro: </b>{emp.livro.nomeLivro}</span>
                        <span><b>Data do emprestimo: </b>{emp.data[2]}/{emp.data[1]}/{emp.data[0]}</span>
                        <span><b>Data do devolução: </b>{emp.dataLimite[2]}/{emp.dataLimite[1]}/{emp.dataLimite[0]}</span>
                        {emp.dataLimite[2] >= dataAtual ?
                        <span className=''Name='multa'>Aplicar multa</span>
                        :
                        <span></span>
                        } 
                    </div>
                    )}
                    {showModal === true ? 
                    <CriaEmprestimo />
                    :
                    <div></div>
                    }
                </div>
            </div>
        </div>
    )
}

export default Emprestimo;