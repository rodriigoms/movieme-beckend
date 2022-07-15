package com.api.movieme.repositories;

import com.api.movieme.models.Filme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    Page<Filme> findByTituloLikeOrderByTitulo(String titulo, Pageable pageable);

}
