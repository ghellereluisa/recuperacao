import { Route, Routes } from "react-router-dom";
import App from "./Pages/index";
import Livro from "./Pages/Livro";
import DetalheLivro from "./Pages/DetalheLivro";


function RotasFuncionando(){
    return(
        <Routes>
            <Route path="/" element={<App/>} exact />
            <Route path="/livro" element={<Livro/>} />
            <Route path="/livro/:id" element={<DetalheLivro/>} />
        </Routes>
    )
}


export default RotasFuncionando;