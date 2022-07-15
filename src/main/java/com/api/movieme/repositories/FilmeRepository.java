package com.api.movieme.repositories;

import com.api.movieme.models.Filme;
import com.api.movieme.models.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    Page<Filme> findByTituloLikeOrderById(String titulo, Pageable pageable);
}