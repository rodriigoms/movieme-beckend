package com.api.movieme.controllers;

import com.api.movieme.models.UsuarioFilme;
import com.api.movieme.responses.ApiResponse;
import com.api.movieme.responses.UsuarioFilmesPageResponse;
import com.api.movieme.services.UsuarioFilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/movies")
    public ApiResponse getUsuarioMoviesPages(@RequestParam(defaultValue = "") int userId, Pageable pageable) {
        UsuarioFilmesPageResponse usuarioFilmesPageResponse = usuarioFilmeService.getMoviesPageableFilter(userId, pageable);

        return new ApiResponse(200, "", usuarioFilmesPageResponse);
    }
}
