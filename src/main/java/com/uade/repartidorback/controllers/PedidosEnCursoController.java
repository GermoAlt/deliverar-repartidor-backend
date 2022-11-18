package com.uade.repartidorback.controllers;

import com.uade.repartidorback.entities.Pedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("deliverar/v1/currentorders")
public class PedidosEnCursoController {

    @PostMapping("/")
    public ResponseEntity nuevoPedidoEnCurso (@RequestBody Pedido pedido){
        return null;
    }

    @GetMapping("/")
    public ResponseEntity pedidoEnCursoPorUser (@RequestParam int idUser){
        return null;
    }

    @PutMapping("/")
    public ResponseEntity updatePedido (@RequestBody Pedido pedido) {
        return null;
    }
}
