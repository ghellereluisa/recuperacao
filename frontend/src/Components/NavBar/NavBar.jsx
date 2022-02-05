


function NavBar() {
    return(
        <nav className="fixed top-6 bottom-0 -right-full bg-primary w-52 md:w-auto md:static transition-all">
            <ul className="md:flex">
                <li>
                    <a className="block p-3" href="/livro">Livro</a>
                </li>
                <li>
                    <a className="block p-3" href="/autores">Autor</a>
                </li>
                <li>
                    <a className="block p-3" href="#">Emprestimo</a>
                </li>
                <li>
                    <a className="block p-3" href="/editora">Editora</a>
                </li>
                <li>
                    <a className="block p-3" href="/exemplar">Exemplar</a>
                </li>
            </ul>
        </nav>
    )
}

export default NavBar;