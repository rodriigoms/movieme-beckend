package com.api.movieme.controllers;

import com.api.movieme.dtos.FilmeUserDTO;
import com.api.movieme.dtos.UsuarioFilmeDTO;
import com.api.movieme.models.Filme;
import com.api.movieme.models.Usuario;
import com.api.movieme.models.UsuarioFilme;
import com.api.movieme.responses.ApiResponse;
import com.api.movieme.services.UsuarioFilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user_movie")
public class UsuarioFilmeController {

    @Autowired
    UsuarioFilmeService usuarioFilmeService;

    @PostMapping("/add")
    public ApiResponse addMovie(@RequestBody UsuarioFilme usuarioFilme) {
        usuarioFilmeService.save(usuarioFilme);
        return new ApiResponse(200, "Filme adicionado com sucesso", null);
    }

    @PostMapping("/movies")
    public ApiResponse getMovies(@RequestBody Usuario usuario) {
        List<Object[]> filmes = usuarioFilmeService.getMoviesByUser(usuario);
        List<UsuarioFilmeDTO> response = new ArrayList<>();

        for (Object[] filme : filmes) {
            UsuarioFilmeDTO u = new UsuarioFilmeDTO();
            u.setId((Integer) filme[0]);
            u.setAno_lancamento((String) filme[1]);
            u.setTitulo((String) filme[2]);
            u.setGeneros((String) filme[3]);
            u.setAvaliacao((Double) filme[4]);
            response.add(u);
        }
        return new ApiResponse(200, "Lista de filmes carregada com sucesso.", response);
    }
}
