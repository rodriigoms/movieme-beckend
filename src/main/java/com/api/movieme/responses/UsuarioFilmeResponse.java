package com.api.movieme.responses;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UsuarioFilmeResponse implements Serializable {

    private int filme_id;
    private int usuario_id;
    private float avaliacao;
}
