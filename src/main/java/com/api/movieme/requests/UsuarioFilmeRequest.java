package com.api.movieme.requests;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UsuarioFilmeRequest implements Serializable {

    private int filme_id;
    private int usuario_id;
    private float avaliacao;
}
