package com.recuperacao.backend.Repository;

import com.recuperacao.backend.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
