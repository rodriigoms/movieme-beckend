package com.api.movieme.repositories;

import com.api.movieme.models.Filme;
import com.api.movieme.models.Usuario;
import com.api.movieme.models.UsuarioFilme;
import com.api.movieme.models.UsuarioFilmeId;
import com.api.movieme.responses.UsuarioFilmeResponse;
import com.api.movieme.responses.UsuarioResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioFilmeRepository extends JpaRepository<UsuarioFilme, UsuarioFilmeId> {

    @Query
    (
            value = "select f from UsuarioFilme uf " +
                    "inner join uf.filme f " +
                    "where uf.usuario = :usuarioId"
    )
    List<Filme> getUserMovies(int usuarioId);
}
