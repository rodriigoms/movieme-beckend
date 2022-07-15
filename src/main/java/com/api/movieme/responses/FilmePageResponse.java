package com.api.movieme.responses;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class FilmePageResponse implements Serializable {

    List<FilmeResponse> filmes;
    int totalPages;
    int pageNumber;
}
