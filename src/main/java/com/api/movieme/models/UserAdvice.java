package com.api.movieme.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario_recomendacao")
public class UserAdvice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private User user;

    @Column(name = "tipo_recomendacao")
    private int tipoRecomendacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTipoRecomendacao() {
        return tipoRecomendacao;
    }

    public void setTipoRecomendacao(int tipoRecomendacao) {
        this.tipoRecomendacao = tipoRecomendacao;
    }
}
