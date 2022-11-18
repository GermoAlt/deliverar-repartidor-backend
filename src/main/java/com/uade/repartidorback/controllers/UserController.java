package com.uade.repartidorback.controllers;

import com.uade.repartidorback.entities.User;
import com.uade.repartidorback.models.InfoResponse;
import com.uade.repartidorback.models.LoginRequest;
import com.uade.repartidorback.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("deliverar/v1/")

public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> autenticarUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok().body(new InfoResponse(HttpStatus.OK.value(),userDetails, "Usuario correcto"));
    }

    @GetMapping("/payments")
    public ResponseEntity obtenerPagos (@RequestParam int idUser){
        return null;
    }

}
