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

    public List<UsuarioFilmeDTO> getFilmesSimilareByUser(int id){

        Usuario usuario2;


        List<UsuarioFilme> allFilmesUsuario = usuarioFilmeService.getAllUsuarioFilmes();

        List<UsuarioFilmeDTO> filmesSimilares = new ArrayList<>();

        for (UsuarioFilme usuarioFilme : allFilmesUsuario) {
            int usuario2_id = usuarioFilme.getId().getUsuarioId();

            if (!Objects.equals(id, usuario2_id)) {
                List<UsuarioFilmeDTO> resultFilmesUsuario2 = new ArrayList<>();
                double similaridade = encontraSimilares(id, usuario2_id);
                if (similaridade > 0.8) {
                    resultFilmesUsuario2 = usuarioFilmeService.getUsuarioMovies(usuario2_id);
                    filmesSimilares.addAll(resultFilmesUsuario2);
                }
            }
        }


        return filmesSimilares;
    }

    private double encontraSimilares(int usuario_id, int usuario2_id){

        List<UsuarioFilme> filmesUsuario2 = usuarioFilmeService.getUsuarioFilmesAvaliacao(usuario2_id);

        return funcaoEuclidiana(usuario_id, filmesUsuario2);
    }

    private double funcaoEuclidiana(int usuario_id, List<UsuarioFilme> filmesUsuario2){
        double resultado = 0;
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
            return 0;

        for(int i=0; i< filmesUsuario1.size();i++){
            for(int j=0; j<filmesUsuario2.size();j++){
                if (Objects.equals(filmesUsuario1.get(i).getId(), filmesUsuario2.get(j).getFilme().getId())) {
                    resultado = resultado + Math.pow((filmesUsuario1.get(i).getAvaliacao() - filmesUsuario2.get(j).getAvaliacao()), 2);
                }
            }
        }

        return 1/(1 + Math.sqrt(resultado));
    }

}
