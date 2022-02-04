import Index from './Pages/Index';
import Emprestimo from './Pages/Emprestimos';
import Usuario from './Pages/Usuario';

import {Routes, Route} from 'react-router-dom';

function Routas() {
    return (
        <Routes>
            <Route path="/" element={<Index />} exact />
            <Route path="/emprestimo" element={<Emprestimo />} />
            <Route path="/usuario" element={<Usuario />} />

        </Routes>
    )
}

export default Routas;
