import Index from './Paginas/Index';
import Emprestimo from './Paginas/Emprestimo';
import Usuario from './Paginas/Usuario';
import CriaLivro from './Paginas/CriaLivro';

import {Routes, Route} from 'react-router-dom';

function Rotas() {
    return (
        <Routes>
            <Route path="/" element={<Index />} exact />
            <Route path="/emprestimos" element={<Emprestimo />} />
            <Route path="/usuarios" element={<Usuario />} />
            <Route path="/cria-livro" element={<CriaLivro />} />
        </Routes>
    )
}

export default Rotas;
