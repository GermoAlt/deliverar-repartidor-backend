package com.uade.repartidorback.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("deliverar/v1/orders")
public class PedidosController {

    @GetMapping("/")
    public ResponseEntity obtenerPedidos (){

        return null;
    }

    @GetMapping("/{idUser}")
    public ResponseEntity obtenerPedidoPorUser (@PathVariable int idUser){
        return null;
    }

}
