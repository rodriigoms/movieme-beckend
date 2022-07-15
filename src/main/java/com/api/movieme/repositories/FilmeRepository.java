package com.api.movieme.repositories;

import com.api.movieme.models.Filme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    Page<Filme> findByTituloLikeOrderByTitulo(String titulo, Pageable pageable);

    Filme findById(int id);

}
