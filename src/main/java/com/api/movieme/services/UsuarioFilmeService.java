package com.api.movieme.services;

import com.api.movieme.dtos.UsuarioFilmeDTO;
import com.api.movieme.models.Usuario;
import com.api.movieme.models.UsuarioFilme;
import com.api.movieme.repositories.UsuarioFilmeRepository;
import com.api.movieme.responses.UsuarioFilmesPageResponse;
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

    public List<Object[]> getMoviesByUser(Usuario usuario) {
        return usuarioFilmeRepository.getUserMovies(usuario.getId());
    }

    public UsuarioFilmesPageResponse getMoviesPageableFilter(int userId, Pageable pageable) {
        Page<Object[]> filmes = usuarioFilmeRepository.getUserMoviesPage(userId, pageable);
        List<UsuarioFilmeDTO> usuarioFilmeDTOList = new ArrayList<>();


        for (Object[] filme : filmes.getContent()) {
            UsuarioFilmeDTO usuarioFilmeDTO = new UsuarioFilmeDTO();
            usuarioFilmeDTO.setId((Integer) filme[0]);
            usuarioFilmeDTO.setAno_lancamento((String) filme[1]);
            usuarioFilmeDTO.setTitulo((String) filme[2]);
            usuarioFilmeDTO.setGeneros((String) filme[3]);
            usuarioFilmeDTO.setAvaliacao((Double) filme[4]);
            usuarioFilmeDTOList.add(usuarioFilmeDTO);
        }

        UsuarioFilmesPageResponse response = new UsuarioFilmesPageResponse();

        response.setFilmes(usuarioFilmeDTOList);
        response.setPageNumber(filmes.getPageable().getPageNumber());
        response.setTotalPages(filmes.getTotalPages());

        return response;
    }
}
