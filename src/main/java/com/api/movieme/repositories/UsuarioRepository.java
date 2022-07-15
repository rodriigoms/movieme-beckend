package com.api.movieme.repositories;

import com.api.movieme.models.Usuario;
import com.api.movieme.responses.UsuarioResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    default UsuarioResponse mySave(Usuario usuario) {
        Usuario u = save(usuario);
        UsuarioResponse response = new UsuarioResponse();

        response.setId(u.getId());
        response.setNome(u.getNome());
        response.setEmail(u.getEmail());
        response.setUsername(u.getUsername());

        return  response;
    }

    List<Usuario> findByEmailOrUsernameAndSenha(String email, String username, String senha);
}
