package com.api.movieme.services;

import com.api.movieme.models.Usuario;
import com.api.movieme.repositories.UsuarioRepository;
import com.api.movieme.requests.LoginRequest;
import com.api.movieme.responses.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public boolean existsByUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }

    public UsuarioResponse save(Usuario usuario) {
        return usuarioRepository.mySave(usuario);
    }

    public UsuarioResponse login(LoginRequest request) {
        List<Usuario> usuarios = usuarioRepository.findByEmailOrUsernameAndSenha(request.getLogin(), request.getLogin(), request.getSenha());

        if (usuarios.isEmpty()) return null;

        Usuario usuario = usuarios.get(0);
        UsuarioResponse response = new UsuarioResponse();

        response.setUsername(usuario.getUsername());
        response.setId(usuario.getId());
        response.setEmail(usuario.getEmail());
        response.setNome(usuario.getNome());

        return response;
    }

    public Usuario loginComplete(LoginRequest request) {
        List<Usuario> usuarios = usuarioRepository.findByEmailOrUsernameAndSenha(request.getLogin(), request.getLogin(), request.getSenha());

        if (usuarios.isEmpty()) return null;

        Usuario usuario = usuarios.get(0);
        UsuarioResponse response = new UsuarioResponse();

        response.setUsername(usuario.getUsername());
        response.setId(usuario.getId());
        response.setEmail(usuario.getEmail());
        response.setNome(usuario.getNome());

        return usuario;
    }
}
