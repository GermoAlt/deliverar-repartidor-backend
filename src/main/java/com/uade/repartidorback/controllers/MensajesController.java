package com.uade.repartidorback.controllers;

import com.uade.repartidorback.models.Mensaje;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MensajesController {

    @MessageMapping("/")
    @SendTo("/topic/repartidor")
    public Mensaje obtenerMensajes(@RequestParam String canal, Mensaje msg) throws Exception {
        Mensaje nuevo = new Mensaje(msg.getContenido(),msg.getEmisor());
        return nuevo;
    }

}
