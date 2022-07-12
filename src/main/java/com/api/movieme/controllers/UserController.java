package com.api.movieme.controllers;

import com.api.movieme.dtos.UserDTO;
import com.api.movieme.models.User;
import com.api.movieme.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<Object> registerNewUser(@RequestBody @Valid UserDTO userDTO) {
        var user = new User();

        BeanUtils.copyProperties(userDTO, user);

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
}
