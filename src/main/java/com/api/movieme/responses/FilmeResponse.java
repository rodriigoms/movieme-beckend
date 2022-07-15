package com.api.movieme.responses;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
public class FilmeResponse implements Serializable {

    private Integer id;
    private String titulo;
    private String ano_lancamento;
    private String generos;
}
