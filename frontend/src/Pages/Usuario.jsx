import { useState, useEffect } from "react";
import NavBar from "../Components/NavBar";
import api from '../api';
import CriaUsuario from '../Components/CriaUsuario';
import EditarUsuario from "../Components/EditarUsuario";


function Usuario() {

    const [usuario, setUsuario] = useState([]);
    const [modalUsuario, setModalUsuario] = useState(false);
    const [modalEditaUsuario, setModalEditaUsuario] = useState(false);
    const [idUsuario, setIdUsuario] = useState(null);

    useEffect(() => {
        async function getUsuario() {
            const response = await api.get('/usuario')
            console.log(response)
            setUsuario(response.data);
        }
        getUsuario();
    }, [])

    async function delUsuario() {
        const resp = await api.delete(`/usuario/${idUsuario}`)
        window.location.reload();
    }

    return(
        <div className="container-fluid mt-5 pt-3 text-center">
            <h2 className='color-muted-pink'> Sistema Empilhados na Estante</h2>
            <h4 className='color-muted-pink' >Usuarios</h4>
            <div className="container d-flex justify-content-between mt-5 pt-3">
                <NavBar />
                <div>
                    <button onClick={() => setModalUsuario(!modalUsuario)}>Criar Novo Usuario</button>
                    {usuario.map(user =>
                    <div className='' Name="div-usuario" key={user.idUsuario}>
                        <div className='' Name="div-usuario-buttons">

                            <button className='' Name="editar" onClick={() => {
                                setIdUsuario(user.idUsuario);
                                setModalEditaUsuario(!modalEditaUsuario);
                            }}>Editar</button>

                            <button className='' Name="excluir" onClick={() => {
                                setIdUsuario(user.idUsuario);
                                delUsuario();
                            }}>Excluir</button>
                        </div>
                        <h2>{user.nomeUsuario}</h2>
                        <span><b>Email: </b>{user.email}</span>
                    </div>    
                    )}
                    {modalUsuario ? 
                        <CriaUsuario />
                        :
                        <div className='' Name="empty"></div>
                    }

                    {modalEditaUsuario && idUsuario &&
                        <EditarUsuario id={idUsuario}/>
                    }
                </div>
            </div>
        </div>
    )
}

export default Usuario;