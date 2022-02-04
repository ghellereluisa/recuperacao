import { useState, useEffect } from 'react';
import NavBar from '../Components/NavBar/NavBar';
import api from '../Service/api';
import CriaEmprestimo from '../Components/CriarEmprestimo';


function Emprestimo(){

    return(
        <div>
            <div className='mt-10rem, bg-color-primary, bd-md'>
                <NavBar/>
                <h1 className=''name='titulo'>
                    Estoque Empilhados na estante
                </h1>



            </div>
        </div>
        
    )
}

export default Emprestimo;