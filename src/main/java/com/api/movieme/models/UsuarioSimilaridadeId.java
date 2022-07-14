package com.api.movieme.models;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class UsuarioSimilaridadeId implements Serializable {
    private Usuario usuario1;
    private Usuario usuario2;

    @ManyToOne(cascade = CascadeType.ALL)
    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }
}
