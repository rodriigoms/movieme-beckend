package com.api.movieme.repositories;

import com.api.movieme.models.UsuarioFilme;
import com.api.movieme.models.UsuarioFilmeId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioFilmeRepository extends JpaRepository<UsuarioFilme, UsuarioFilmeId> {


    @Query(value = "select f.id as id, f.ano_lancamento as ano_lancamento, f.titulo as titulo, f.generos as generos, uf.avaliacao as avaliacao " +
            "from usuario_filme as uf " +
            "inner join filme as f on uf.filme_id = f.id " +
            "where uf.usuario_id = :id", nativeQuery = true)
    List<Object[]> getUserMovies(@Param(value = "id") int id);
    @Query(value = "select f.id as id, f.ano_lancamento as ano_lancamento, f.titulo as titulo, f.generos as generos, uf.avaliacao as avaliacao " +
            "from usuario_filme as uf " +
            "inner join filme as f on uf.filme_id = f.id " +
            "where uf.usuario_id = :id order by f.nome", nativeQuery = true)
    Page<Object[]> getUserMoviesPage(int id, Pageable pageable);
}
