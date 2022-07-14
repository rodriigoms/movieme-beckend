package com.api.movieme.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario_recomendacao")
@AssociationOverrides({
        @AssociationOverride(name = "usuario",
                joinColumns = @JoinColumn(name = "usuario_id")),
        @AssociationOverride(name = "filme",
                joinColumns = @JoinColumn(name = "fk_filme")) })
public class UsuarioRecomendacao implements Serializable {

    private UsuarioRecomendacaoId primaryKey = new UsuarioRecomendacaoId();

    private int tipoRecomendacao;

    @EmbeddedId
    public UsuarioRecomendacaoId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(UsuarioRecomendacaoId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Column(name = "tipo_recomendacao")
    public int getTipoRecomendacao() {
        return tipoRecomendacao;
    }

    public void setTipoRecomendacao(int tipoRecomendacao) {
        this.tipoRecomendacao = tipoRecomendacao;
    }

    @Transient
    public Usuario getUsuario() {
        return primaryKey.getUsuario();
    }

    public void setUsuario(Usuario usuario) {
        primaryKey.setUsuario(usuario);
    }

    @Transient
    public Filme getFilme() {
        return primaryKey.getFilme();
    }

    public void setFilme(Filme filme) {
        primaryKey.setFilme(filme);
    }
}
