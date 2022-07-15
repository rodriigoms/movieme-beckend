package com.api.movieme.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "filme_similaridade")
@Getter
@Setter
public class FilmeSimilaridade implements Serializable {


    @EmbeddedId
    private FilmeSimilaridadeId id = new FilmeSimilaridadeId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("filme1Id")
    private Filme filme1;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("filme2Id")
    private Filme filme2;

    @Column(name = "filme_similaridade")
    private double filmeSimilaridade;
}
