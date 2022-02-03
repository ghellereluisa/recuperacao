import { Link } from 'react-router-dom';


function NavBar() {
    return(
        <div>
            <Link to="/">
                <button>Livro</button>
            </Link>
            <Link to="/emprestimo">
                <button>Emprestimo</button>
            </Link>
            <Link to="/usuario">
                <button>Usuario</button>
            </Link>
        </div>
    )
}

export default NavBar;