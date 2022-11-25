package com.uade.repartidorback.controllers;

import com.uade.repartidorback.entities.Orden;
import com.uade.repartidorback.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("deliverar/v1/currentorders")
public class PedidosEnCursoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping("/")
    public ResponseEntity nuevoPedidoEnCurso (@RequestBody Orden pedido){
        return pedidoService.nuevoPedidoEnCurso(pedido);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity pedidoEnCursoPorUser (@PathVariable String idUser){
        return pedidoService.pedidoEnCursoUser(idUser);
    }

    @PutMapping("/")
    public ResponseEntity updatePedido (@RequestBody Orden pedido) {
        return pedidoService.updatePedidoEnCurso(pedido);
    }
}
