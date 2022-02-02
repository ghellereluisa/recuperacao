package com.recuperacao.backend.Repository;

import com.recuperacao.backend.Model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
