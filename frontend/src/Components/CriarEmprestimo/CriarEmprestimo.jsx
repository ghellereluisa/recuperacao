import { useCallback, useEffect, useState } from "react";


function CriarEmprestimo() {

    const [livroEmprestado, setLivroEmprestado] = useState(null);
    const [usuarioEmprestimo, setUsuarioEmprestimo] = useState(null);
    const [exemplarEmprestimo, setExemplarEmprestimo] = useState(null);
    const [usuarioUsado, setUsuarioUsado] = useState(null);
    

    useEffect(()=>{
        async function GetLivro(){
            const response = await api.get('/livro')
            setLivroEmprestado(response.data);
        }
        GetLivro();
    }, [])

    useEffect(()=> {
        async function GetUsuario(){
            const response = await api.get('/usuario')
            setUsuarioEmprestimo(response.data);
        }
        GetUsuario();
    }, [])

    const CriarEmprestimo = useCallback((e)=>{
        const emprestimo={
            exemplar:{
                idExemplar : exemplarUsado
            },
            usuario:{
                idUsuario : usuarioUsado
            }
        }

        api.post("/emprestimo", emprestimo)
    })


    return (
        <div>
            <h3 className='color-muted-pink'>Criar um Emprestimo</h3>
            <form className='' name='novo-emprestimo-form' onSubmit={CriarEmprestimo}>

                {/* testar pq o meu é com bool */}
                
                <select onChange={(e) => setExemplarEmprestimo(e.target.value)} value={exemplarUsado}>
                    <option value='default'>Nenhum</option>
                    {livroEmprestado?.map((livro) => (
                        <option key={livro.livroId} value={livro.livroId}>{livro.nomeLivro}</option>
                    ))}
                </select>
                <select onChange={(e) => setUsuarioUsado(e.target.value)} value={usuarioUsado}>
                    <option value='default'>Nenhum</option>
                    {usuarioEmprestimo?.map((usuario) => (
                        <option key={usuario.idUsuario} value={usuario.idUsuario}>{usuario.nomeUsuario}</option>
                    ))}
                </select>
                <button type="submit">finalizar</button>
            </form>
        </div>
    )

}
export default CriarEmprestimo;