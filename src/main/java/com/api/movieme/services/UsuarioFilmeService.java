package com.api.movieme.services;

import com.api.movieme.models.Filme;
import com.api.movieme.models.Usuario;
import com.api.movieme.models.UsuarioFilme;
import com.api.movieme.repositories.FilmeRepository;
import com.api.movieme.repositories.UsuarioFilmeRepository;
import com.api.movieme.requests.UsuarioFilmeRequest;
import com.api.movieme.responses.FilmePageResponse;
import com.api.movieme.responses.FilmeResponse;
import com.api.movieme.responses.UsuarioFilmeResponse;
import com.api.movieme.responses.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioFilmeService {

    @Autowired
    UsuarioFilmeRepository usuarioFilmeRepository;

    public UsuarioFilme save(UsuarioFilme usuarioFilme) {
        return usuarioFilmeRepository.save(usuarioFilme);
    }

    public List<Filme> getMovies(int usuarioId) {
        return usuarioFilmeRepository.getUserMovies(usuarioId);
    }
}
