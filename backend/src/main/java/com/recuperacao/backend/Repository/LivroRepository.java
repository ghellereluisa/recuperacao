package com.recuperacao.backend.Repository;

import com.recuperacao.backend.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
