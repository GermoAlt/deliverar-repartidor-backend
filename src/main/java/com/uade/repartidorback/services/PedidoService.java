package com.uade.repartidorback.services;

import com.uade.repartidorback.entities.Orden;
import com.uade.repartidorback.models.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface PedidoService {
    ResponseEntity obtenerPedidos ();
    ResponseEntity obtenerOrdenesCompletadas(String idUser, String estado);
    ResponseEntity nuevoPedidoEnCurso (Orden orden);
}
