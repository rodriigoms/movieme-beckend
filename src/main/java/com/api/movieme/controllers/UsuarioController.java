package com.api.movieme.controllers;

import com.api.movieme.dtos.UserDTO;
import com.api.movieme.models.Filme;
import com.api.movieme.models.Usuario;
import com.api.movieme.models.UsuarioFilme;
import com.api.movieme.requests.LoginRequest;
import com.api.movieme.requests.UsuarioRequest;
import com.api.movieme.responses.ApiResponse;
import com.api.movieme.responses.UsuarioResponse;
import com.api.movieme.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ApiResponse cadastro(@RequestBody @Valid UserDTO userDTO) {
        if (usuarioService.existsByEmail(userDTO.getEmail())) {
            return new ApiResponse(409, "Este e-mail já está cadastrado.", null);
        }
        if (usuarioService.existsByUsername(userDTO.getUsername())) {
            return new ApiResponse(409, "Já existe uma conta com este nome de usuário.", null);
        }

        Usuario usuario = new Usuario();

        BeanUtils.copyProperties(userDTO, usuario);

        return new ApiResponse(200, "Usuário cadastrado com sucesso!", usuarioService.save(usuario));
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginRequest request) {
        UsuarioResponse response = usuarioService.login(request);

        if (response == null) return new ApiResponse(550, "Login ou senha incorretos!", null);
        return new ApiResponse(200, "Login efetuado com sucesso!", response);
    }
}
