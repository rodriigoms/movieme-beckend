package com.api.movieme.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {

    private int id;
    private String nome;
    private String email;
    private String username;
}
