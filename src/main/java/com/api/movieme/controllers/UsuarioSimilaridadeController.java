package com.api.movieme.controllers;

import com.api.movieme.dtos.UsuarioFilmeDTO;
import com.api.movieme.models.Filme;
import com.api.movieme.models.UsuarioFilme;
import com.api.movieme.responses.ApiResponse;
import com.api.movieme.responses.UsuarioFilmesPageResponse;
import com.api.movieme.services.UsuarioFilmeService;
import com.api.movieme.services.UsuarioSimilaridadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/similaridade")
public class UsuarioSimilaridadeController {

    @Autowired
    UsuarioSimilaridadeService usuarioSimilaridadeService;

    @GetMapping("/by_user")
    public ApiResponse getSimilarityByUser(@RequestParam(defaultValue = "") int userId) {
        List<UsuarioFilmeDTO> filmeList = new ArrayList<>();
        filmeList =  usuarioSimilaridadeService.getFilmesSimilareByUser(userId);

        return new ApiResponse(200, "", filmeList);
    }
}
