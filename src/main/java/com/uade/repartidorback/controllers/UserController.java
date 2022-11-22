package com.uade.repartidorback.controllers;

import com.uade.repartidorback.entities.User;
import com.uade.repartidorback.models.InfoResponse;
import com.uade.repartidorback.models.LoginRequest;
import com.uade.repartidorback.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("deliverar/v1/")

public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> autenticarUser(@Valid @RequestBody LoginRequest loginRequest) {
        return userService.registrarUser(loginRequest);
    }

    @GetMapping("/payments")
    public ResponseEntity obtenerPagos (@RequestParam int idUser){
        return null;
    }

}
