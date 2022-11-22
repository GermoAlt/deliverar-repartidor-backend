package com.uade.repartidorback.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.uade.repartidorback.entities.Orden;
import com.uade.repartidorback.entities.User;
import com.uade.repartidorback.enums.TipoEnum;
import com.uade.repartidorback.models.InfoResponse;
import com.uade.repartidorback.models.LoginRequest;
import com.uade.repartidorback.models.Mensaje;
import com.uade.repartidorback.models.MensajeCanal;
import com.uade.repartidorback.repositories.PedidoRepository;
import com.uade.repartidorback.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;


@Service
public class MensajeServiceImpl implements MensajeService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public ResponseEntity guardarMensaje(Mensaje mensaje) {
        Gson gson = new Gson();
        JsonObject jsonObject = new Gson().fromJson(mensaje.getContenido(), JsonObject.class);
//        if(jsonObject.get("tipo").getAsString().equals(TipoEnum.PEDIDO.name().toLowerCase())){
            Orden pedido = gson.fromJson(jsonObject.getAsJsonObject("mensaje"), Orden.class);
            return ResponseEntity.created(null).body(new InfoResponse(HttpStatus.CREATED.value(), pedidoRepository.save(pedido),"Pedido registrado"));
//        }
    }
}
