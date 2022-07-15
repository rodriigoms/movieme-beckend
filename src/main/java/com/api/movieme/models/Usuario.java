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

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsuarioFilme> filmesUsuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsuarioRecomendacao> filmesRecomendacao;

    @OneToMany(mappedBy = "usuario1", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsuarioSimilaridade> usuarios2Similaridades;

    @OneToMany(mappedBy = "usuario2", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsuarioSimilaridade> usuarios1Similaridades;
}
