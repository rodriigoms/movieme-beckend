package com.api.movieme.services;

import com.api.movieme.dtos.UsuarioFilmeDTO;
import com.api.movieme.models.*;
import com.api.movieme.repositories.UsuarioSimilaridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UsuarioSimilaridadeService {
    @Autowired
    private UsuarioFilmeService usuarioFilmeService;
    @Autowired
    private FilmeService filmeService;

    @Autowired
    UsuarioSimilaridadeRepository usuarioSimilaridadeRepository;

    public List<Filme> getFilmesSimilareByUser(int id){
        List<UsuarioSimilaridade> resultado = new ArrayList<>();
        Usuario usuario2;


        List<UsuarioFilme> allFilmesUsuario = usuarioFilmeService.getAllUsuarioFilmes();

        List<Filme> filmesSimilares = new ArrayList<>();

        for (UsuarioFilme usuarioFilme : allFilmesUsuario) {
            int usuario2_id = usuarioFilme.getId().getUsuarioId();

            if (!Objects.equals(id, usuario2_id)) {
                List<Filme> resultFilmesSimilares = new ArrayList<>();
                resultFilmesSimilares = encontraSimilares(id, usuario2_id);
                if (resultFilmesSimilares != null) {
                    filmesSimilares.addAll(resultFilmesSimilares);
                }
            }
        }


        return filmesSimilares;
    }

    private List<Filme> encontraSimilares(int usuario_id, int usuario2_id){

        List<UsuarioFilme> filmesUsuario2 = usuarioFilmeService.getUsuarioFilmesAvaliacao(usuario2_id);

        List<Filme> filmesSimilares = new ArrayList<>();
        filmesSimilares = funcaoEuclidiana(usuario_id, filmesUsuario2);

        return filmesSimilares;
    }

    private List<Filme> funcaoEuclidiana(int usuario_id, List<UsuarioFilme> filmesUsuario2){
        int aux = 0;
        List<Filme> filmes = new ArrayList<>();

        List<UsuarioFilmeDTO> filmesUsuario1 = usuarioFilmeService.getUsuarioMovies(usuario_id);

        for(int i = 0; i < filmesUsuario1.size(); i++){
            for(int j=0; j < filmesUsuario1.size();j++){
                if (Objects.equals(filmesUsuario1.get(i).getId(), filmesUsuario2.get(j).getFilme().getId())) {
                    aux = 1;
                    break;
                }
            }
        }

        if (aux == 1)
            return null;

        for(int i=0; i< filmesUsuario1.size();i++){
            for(int j=0; j<filmesUsuario2.size();j++){
                if (filmesUsuario1.get(i).getAvaliacao() == filmesUsuario2.get(j).getAvaliacao()) {
                    Filme filme = new Filme();
                    filme = filmeService.findById(filmesUsuario2.get(j).getId().getFilmeId());

                    filmes.add(filme);
                }
            }
        }

        return filmes;
    }

}
