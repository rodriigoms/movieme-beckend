package com.api.movieme.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario_filme")
@Getter
@Setter
public class UsuarioFilme implements Serializable {

    @EmbeddedId
    private UsuarioFilmeId id = new UsuarioFilmeId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("usuarioId")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("filmeId")
    private Filme filme;

    @Column(name = "avaliacao")
    private double avaliacao;
}
