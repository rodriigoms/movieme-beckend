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
public class UsuarioFilmeId implements Serializable {

    public UsuarioFilmeId(int usuarioId, int filmeId) {
        this.usuarioId = usuarioId;
        this.filmeId = filmeId;
    }

    public UsuarioFilmeId() {
    }

    @Column(name = "usuario_id")
    private int usuarioId;

    @Column(name = "filme_id")
    private int filmeId;
}
