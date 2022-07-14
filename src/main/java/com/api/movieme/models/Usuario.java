package com.api.movieme.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = false, length = 45)
    private String email;

    @Column(nullable = false, length = 45)
    private String senha;

    @Column(nullable = false, length = 45)
    private String username;

    @OneToMany(mappedBy = "primaryKey.usuario", cascade = CascadeType.ALL)
    private Set<UsuarioFilme> usuarioFilme = new HashSet<>();

    @OneToMany(mappedBy = "primaryKey.usuario", cascade = CascadeType.ALL)
    private Set<UsuarioRecomendacao> usuarioRecomendacao = new HashSet<>();

    @OneToMany(mappedBy = "primaryKey.usuario1", cascade = CascadeType.ALL)
    private Set<UsuarioSimilaridade> usuarioSimilaridade1 = new HashSet<>();

    @OneToMany(mappedBy = "primaryKey.usuario2", cascade = CascadeType.ALL)
    private Set<UsuarioSimilaridade> usuarioSimilaridade2 = new HashSet<>();
}
