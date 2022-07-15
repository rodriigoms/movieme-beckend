package com.api.movieme.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario_similaridade")
@Getter
@Setter
public class UsuarioSimilaridade implements Serializable {


    @EmbeddedId
    private UsuarioSimilaridadeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("usuario1Id")
    private Usuario usuario1;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("usuario2Id")
    private Usuario usuario2;

    @Column(name = "usuario_similaridade")
    private double usuarioSimilaridade;
}
