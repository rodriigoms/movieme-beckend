package com.api.movieme.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDTO {

    @NotBlank(message = "Nome é obrigatório.")
    @Size(max = 45)
    private String nome;

    @NotBlank(message = "E-mail é obrigatório.")
    @Size(max = 45)
    private String email;

    @NotBlank(message = "Senha é obrigatória.")
    @Size(max = 45)
    private String senha;

    @NotBlank(message = "Nome de usuário é obrigatório")
    @Size(max = 45)
    private String username;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
