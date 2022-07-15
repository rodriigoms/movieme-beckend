package com.api.movieme.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "filme")
@Getter
@Setter
public class Filme implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String ano_lancamento;

    @Column
    private String generos;

    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsuarioFilme> usuariosFilme;

    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsuarioRecomendacao> usuariosRecomendacao;

    @OneToMany(mappedBy = "filme1", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FilmeSimilaridade> filme1Similaridade;

    @OneToMany(mappedBy = "filme2", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FilmeSimilaridade> filme2Similaridade;

}
