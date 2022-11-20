package com.uade.repartidorback.services;

import com.uade.repartidorback.models.LoginRequest;
import com.uade.repartidorback.models.SignupRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity registrarUser (LoginRequest loginRequest);
    ResponseEntity obtenerUser (String id);
}
