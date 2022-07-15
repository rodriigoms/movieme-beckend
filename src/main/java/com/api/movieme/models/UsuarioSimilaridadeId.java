package com.api.movieme.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class UsuarioSimilaridadeId implements Serializable {

    @Column(name = "usuario1_id")
    private int usuario1Id;

    @Column(name = "usuario1_id")
    private int usuario2Id;
}
