import { Route, Routes } from "react-router-dom";
import App from "./Pages/index";
import Livro from "./Pages/Livro";
import DetalheLivro from "./Pages/DetalheLivro";
import Autores from "./Pages/Autores";
import Editora from "./Pages/Editora";
import Exemplar from "./Pages/Exemplar";


function RotasFuncionando(){
    return(
        <Routes>
            <Route path="/" element={<App/>} exact />
            <Route path="/livro" element={<Livro/>} />
            <Route path="/livro/:id" element={<DetalheLivro/>} />
            <Route path="/autores" element={<Autores/>} />
            <Route path="/editora" element={<Editora/>} />
            <Route path="/exemplar" element={<Exemplar/>} />


        </Routes>
    )
}


export default RotasFuncionando;