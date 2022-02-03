import React from 'react';
import { Link } from 'react-router-dom';

import { Navbar } from './style'

function Header() {
  return (
    <Navbar>
        <ul>
            <Link to="livro">
                <li>Livros</li>
            </Link>
            <Link to="autor">
                <li>Autores</li>
            </Link>
            <Link to="areaconhecimento">
                <li>Area Conhecimento</li>
            </Link>
            <Link to="editora">
                <li>Editoras</li>
            </Link>
            <Link to="emprestimo">
                <li>Emprestimos</li>
            </Link>
            <Link to="categoria">
                <li>Categorias</li>
            </Link>
            <Link to="leitor">
                <li>Leitor</li>
            </Link>
        </ul>
    </Navbar>
  );
}

export default Header;
