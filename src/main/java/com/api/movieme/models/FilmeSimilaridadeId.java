package com.api.movieme.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class FilmeSimilaridadeId implements Serializable {

    @Column(name = "filme1_id")
    private int filme1Id;

    @Column(name = "filme1_id")
    private int filme2Id;
}
