package com.uade.repartidorback.services;

import com.uade.repartidorback.entities.Orden;
import com.uade.repartidorback.models.Mensaje;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface MensajeService {
    ResponseEntity guardarMensaje (Mensaje mensaje);
}
