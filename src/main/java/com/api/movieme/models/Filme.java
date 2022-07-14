package com.api.movieme.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "filme")
@Getter
@Setter
public class Filme implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String titulo;

    @Column(nullable = false)
    private String ano_lancamento;

    @Column
    private String generos;

    @OneToMany(mappedBy = "primaryKey.filme", cascade = CascadeType.ALL)
    private Set<UsuarioFilme> usuarioFilme = new HashSet<>();

    @OneToMany(mappedBy = "primaryKey.filme", cascade = CascadeType.ALL)
    private Set<UsuarioRecomendacao> usuarioRecomendacao = new HashSet<>();

}
