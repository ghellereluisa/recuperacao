package com.recuperacao.backend.Repository;

import com.recuperacao.backend.Model.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {
}
