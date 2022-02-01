package com.recuperacao.backend.Repository;

import com.recuperacao.backend.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
