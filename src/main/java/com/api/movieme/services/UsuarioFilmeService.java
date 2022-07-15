package com.api.movieme.services;

import com.api.movieme.dtos.FilmeUserDTO;
import com.api.movieme.models.Filme;
import com.api.movieme.models.Usuario;
import com.api.movieme.models.UsuarioFilme;
import com.api.movieme.repositories.UsuarioFilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UsuarioFilmeService {

    @Autowired
    UsuarioFilmeRepository usuarioFilmeRepository;

    public UsuarioFilme save(UsuarioFilme usuarioFilme) {
        return usuarioFilmeRepository.save(usuarioFilme);
    }

    public List<Object[]> getMoviesByUser(Usuario usuario) {
        return usuarioFilmeRepository.getUserMovies(usuario.getId());
    }
}
