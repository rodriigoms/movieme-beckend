package com.api.movieme.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario_similaridade")
@AssociationOverrides({
        @AssociationOverride(name = "usuario",
                joinColumns = @JoinColumn(name = "usuario1_id")),
        @AssociationOverride(name = "usuario",
                joinColumns = @JoinColumn(name = "usuario2_id")) })
public class UsuarioSimilaridade implements Serializable {

    private UsuarioSimilaridadeId primaryKey = new UsuarioSimilaridadeId();

    private float similaridade;

    @EmbeddedId
    public UsuarioSimilaridadeId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(UsuarioSimilaridadeId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Usuario getUsuario1() {
        return primaryKey.getUsuario1();
    }

    public void setUsuario1(Usuario usuario1) {
        primaryKey.setUsuario1(usuario1);
    }

    public Usuario getUsuario2() {
        return primaryKey.getUsuario2();
    }

    public void setUsuario2(Usuario usuario2) {
        primaryKey.setUsuario2(usuario2);
    }

    @Column(name = "similaridade")
    public float getSimilaridade() {
        return similaridade;
    }

    public void setSimilaridade(float similaridade) {
        this.similaridade = similaridade;
    }
}
