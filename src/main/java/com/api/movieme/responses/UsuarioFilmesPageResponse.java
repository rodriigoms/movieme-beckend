package com.api.movieme.responses;

import com.api.movieme.dtos.UsuarioFilmeDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UsuarioFilmesPageResponse implements Serializable {

    List<UsuarioFilmeDTO> filmes;
    int totalPages;
    int pageNumber;
}
