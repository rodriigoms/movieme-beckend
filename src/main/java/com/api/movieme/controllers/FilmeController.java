package com.api.movieme.controllers;

import com.api.movieme.responses.ApiResponse;
import com.api.movieme.responses.FilmePageResponse;
import com.api.movieme.responses.FilmeResponse;
import com.api.movieme.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/movie")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/all")
    public ApiResponse getAllMovies() {
        List<FilmeResponse> responseList = filmeService.getAllMovies();

        return new ApiResponse(200, "", responseList);
    }

    @GetMapping("/page")
    public ApiResponse getAllMoviesPageable(Pageable pageable) {
        FilmePageResponse filmePageResponse = filmeService.getPageMovies(pageable);

        return new ApiResponse(200, "", filmePageResponse);
    }

    @GetMapping("/search")
    public ApiResponse getMoviesPageableFilter(@RequestParam(defaultValue = "") String titulo, Pageable pageable) {
        FilmePageResponse filmePageResponse = filmeService.getMoviesPageableFilter(titulo, pageable);

        return new ApiResponse(200, "", filmePageResponse);
    }
}
