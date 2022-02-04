import api from '../../Service/api';
import { useCallback, useEffect, useState } from 'react';


function CriarNovoUsuario() {
    
    const[nome, setNome] = useState("");
    const[rg, setRg] = useState("");
    const[cpf, setCpf] = useState("");
    const[email, setEmail] = useState("");
    const[enderecoRes, setEnderecoRes] = useState("");
    const[enderecoCom, setEnderecoCom] = useState("");
    const[telefone, setTelefone] = useState("");

    const Criar = useCallback(() => {

        const usuario = {
           usuarioNome: nome,
           rg: rg,
           cpf: cpf,
           email: email,
           enderecoRes_url: `viacep.com.br/ws/${cep}/json/unicode/`,
           enderecoCom_url: `viacep.com.br/ws/${cep}/json/unicode/`,
           telelfone: telefone
        }

        api.post("/usuarios", usuario)
    }, [nome, rg, cpf, email, enderecoRes_url, enderecoCom_url, telefone])

    return(
        <div>
            <h3 className='color-muted-pink'>Criar Novo Usuario</h3>
            <form className='' name='criar-novo-usuario' onSubmit={Criar}>
                <input placeholder='Digite seu Nome' type={'text'} onChange={(e) => setNome(e.target.value)}/>
                <input placeholder='Digite seu Rg' type={'text'} onChange={(e) => setRg(e.target.value)}/>
                <input placeholder='Digite seu Cpf' type={'text'} onChange={(e) => setCpf(e.target.value)}/>
                <input placeholder='Digite seu email' type={'text'} onChange={(e) => setEmail(e.target.value)}/>
                <input placeholder='Digite seu CEP Residencial' type={'text'} onChange={(e) => setEnderecoRes(e.target.value)}/>
                <input placeholder='Digite seu CEP Comercial' type={'text'} onChange={(e) => setEnderecoCom(e.target.value)}/>
                <input placeholder='Numero' type={'text'} onChange={(e) => setTelefone(e.target.value)}/>
                <button className='rounded-md, p-4rem, bg-primary-500 hover:bg-primary-600' type='submit'>concluir e terminar</button>
            </form>
        </div>
    )
}

export default CriaNovoUsuario;