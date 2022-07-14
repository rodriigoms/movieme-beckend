package com.api.movieme.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario_filme")
@AssociationOverrides({
@AssociationOverride(name = "usuario",
        joinColumns = @JoinColumn(name = "usuario_id")),
@AssociationOverride(name = "filme",
        joinColumns = @JoinColumn(name = "fk_filme")) })
public class UsuarioFilme implements Serializable {

    private UsuarioFilmeId primaryKey = new UsuarioFilmeId();
    private float avaliacao;

    @EmbeddedId
    public UsuarioFilmeId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(UsuarioFilmeId usuarioFilmeId) {
        this.primaryKey = usuarioFilmeId;
    }
    @Transient
    public Usuario getUsuario() {
        return getPrimaryKey().getUsuario();
    }

    public void setUsuario(Usuario usuario) {
        getPrimaryKey().setUsuario(usuario);
    }

    @Transient
    public Filme getFilme() {
        return getPrimaryKey().getFilme();
    }

    public void setFilme(Filme filme) {
        getPrimaryKey().setFilme(filme);
    }

    @Column(name = "avaliacao")
    public float getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }
}
