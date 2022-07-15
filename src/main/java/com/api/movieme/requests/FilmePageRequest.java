package com.api.movieme.requests;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FilmePageRequest implements Serializable {
    private String titulo;
}
