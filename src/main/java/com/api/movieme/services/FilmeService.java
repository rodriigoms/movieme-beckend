package com.api.movieme.services;

import com.api.movieme.models.Filme;
import com.api.movieme.repositories.FilmeRepository;
import com.api.movieme.responses.FilmePageResponse;
import com.api.movieme.responses.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    public List<FilmeResponse> getAllMovies() {
        List<Filme> filmes = filmeRepository.findAll();
        List<FilmeResponse> filmeResponseList = new ArrayList<>();


        for (Filme filme : filmes) {
            FilmeResponse filmeResponse = new FilmeResponse();

            filmeResponse.setId(filme.getId());
            filmeResponse.setTitulo(filme.getTitulo());
            filmeResponse.setAno_lancamento(filme.getAno_lancamento());
            filmeResponse.setGeneros(filme.getGeneros());
            filmeResponseList.add(filmeResponse);
        }

        return filmeResponseList;
    }

    public FilmePageResponse getPageMovies(Pageable pageable) {
        Page<Filme> filmes = filmeRepository.findAll(pageable);
        List<FilmeResponse> filmeResponseList = new ArrayList<>();


        for (Filme filme : filmes.getContent()) {
            FilmeResponse filmeResponse = new FilmeResponse();
            filmeResponse.setId(filme.getId());
            filmeResponse.setTitulo(filme.getTitulo());
            filmeResponse.setAno_lancamento(filme.getAno_lancamento());
            filmeResponse.setGeneros(filme.getGeneros());
            filmeResponseList.add(filmeResponse);
        }

        FilmePageResponse response = new FilmePageResponse();

        response.setFilmes(filmeResponseList);
        response.setPageNumber(filmes.getPageable().getPageNumber());
        response.setTotalPages(filmes.getTotalPages());

        return response;
    }

    public FilmePageResponse getMoviesPageableFilter(String titulo, Pageable pageable) {
        Page<Filme> filmes = filmeRepository.findByTituloLikeOrderByTitulo(titulo+"%", pageable);
        List<FilmeResponse> filmeResponseList = new ArrayList<>();


        for (Filme filme : filmes.getContent()) {
            FilmeResponse filmeResponse = new FilmeResponse();
            filmeResponse.setId(filme.getId());
            filmeResponse.setTitulo(filme.getTitulo());
            filmeResponse.setAno_lancamento(filme.getAno_lancamento());
            filmeResponse.setGeneros(filme.getGeneros());
            filmeResponseList.add(filmeResponse);
        }

        FilmePageResponse response = new FilmePageResponse();

        response.setFilmes(filmeResponseList);
        response.setPageNumber(filmes.getPageable().getPageNumber());
        response.setTotalPages(filmes.getTotalPages());

        return response;
    }

    public Filme findById(int id) {
        return filmeRepository.findById(id);
    }

}
