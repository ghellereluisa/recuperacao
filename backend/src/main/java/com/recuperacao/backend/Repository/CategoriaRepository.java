package com.recuperacao.backend.Repository;

import com.recuperacao.backend.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
