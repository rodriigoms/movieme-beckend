package com.api.movieme.repositories;

import com.api.movieme.models.UsuarioSimilaridade;
import com.api.movieme.models.UsuarioSimilaridadeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioSimilaridadeRepository extends JpaRepository<UsuarioSimilaridade, UsuarioSimilaridadeId> {
}
