package com.api.movieme.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmeUserDTO {

    private Integer id;
    private String titulo;
    private String ano_lancamento;
    private String generos;

    private double avaliacao;

    public FilmeUserDTO(Integer id, String titulo, String ano_lancamento, String generos, double avaliacao) {
        this.id = id;
        this.titulo = titulo;
        this.ano_lancamento = ano_lancamento;
        this.generos = generos;
        this.avaliacao = avaliacao;
    }
}
