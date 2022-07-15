package com.api.movieme.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class UsuarioRecomendacaoId implements Serializable {
    @Column(name = "usuario_id")
    private int usuarioId;

    @Column(name = "filme")
    private int filmeId;
}
