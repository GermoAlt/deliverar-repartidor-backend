package com.uade.repartidorback.controllers;

import com.uade.repartidorback.enums.EstadoEnum;
import com.uade.repartidorback.services.MensajeService;
import com.uade.repartidorback.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("deliverar/v1/orders")
public class PedidosController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/")
    public ResponseEntity obtenerPedidos (){
        return pedidoService.obtenerPedidos();
    }

    @GetMapping("/")
    public ResponseEntity obtenerPedidosPorUser (@RequestParam String idUser){
        return pedidoService.obtenerOrdenesCompletadas(idUser, EstadoEnum.ENTREGADO.name());
    }

}
