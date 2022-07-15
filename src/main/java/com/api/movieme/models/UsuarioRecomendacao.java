package com.api.movieme.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario_recomendacao")
@Getter
@Setter
public class UsuarioRecomendacao implements Serializable {

    @EmbeddedId
    private UsuarioRecomendacaoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("usuarioId")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("filmeId")
    private Filme filme;

    @Column(name = "tipo_recomendacao")
    private int tipoRecomendacao;
}
