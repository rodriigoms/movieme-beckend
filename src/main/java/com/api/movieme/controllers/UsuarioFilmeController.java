package com.api.movieme.controllers;

import com.api.movieme.models.Filme;
import com.api.movieme.models.UsuarioFilme;
import com.api.movieme.requests.SimpleIdRequest;
import com.api.movieme.requests.UsuarioFilmeRequest;
import com.api.movieme.responses.ApiResponse;
import com.api.movieme.services.UsuarioFilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/user_movies")
    public ApiResponse getMovies(@RequestBody SimpleIdRequest request) {
        List<Filme> filmes = usuarioFilmeService.getMovies(request.getId());
        return new ApiResponse(200, "Lista de filmes carregada com sucesso.", filmes);
    }
}
