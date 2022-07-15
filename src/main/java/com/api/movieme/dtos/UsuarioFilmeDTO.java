package com.api.movieme.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioFilmeDTO {

    private Integer id;
    private String titulo;
    private String ano_lancamento;
    private String generos;
    private double avaliacao;
}
