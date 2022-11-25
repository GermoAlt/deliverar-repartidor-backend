package com.uade.repartidorback.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.uade.repartidorback.entities.Orden;
import com.uade.repartidorback.entities.User;
import com.uade.repartidorback.enums.CanalEnum;
import com.uade.repartidorback.enums.EstadoEnum;
import com.uade.repartidorback.enums.TipoEnum;
import com.uade.repartidorback.models.*;
import com.uade.repartidorback.repositories.PedidoRepository;
import com.uade.repartidorback.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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
        CanalEnum canalEnum = CanalEnum.valueOf(mensaje.getEmisor().toUpperCase());
        canalEnum = CanalEnum.FRANQUICIA;

        switch (canalEnum){
            case CORE :
                return null;
            case FRANQUICIA:
                if(jsonObject.get("tipo").getAsString().equals(TipoEnum.ACTUALIZACION_PEDIDO.label)){
                    if(jsonObject.getAsJsonObject("mensaje").get("order_status").getAsString().equals(EstadoEnum.RETIRAR.name())) {
//                        Orden pedido = new Orden();
//
//                        OrdenFranquicia ordenFranquicia = gson.fromJson(jsonObject.getAsJsonObject("mensaje"), OrdenFranquicia.class);
//                        pedido.setOrderId(ordenFranquicia.getOrder_id());
//                        pedido.setOrderStatus(ordenFranquicia.getOrder_status());
//                        pedido.setName("McDonalds");
//                        pedido.setFranchise_address(ordenFranquicia.getFranchise_address());
//                        pedido.setClient_address(ordenFranquicia.getClient_address());
//                        Platos meals = new Platos();
//                        List<Comidas> comidas = ordenFranquicia.getComidas();
//                        for (Comidas comida: comidas){
//                            meals.setMeal_id(comida.getComida().get_id());
//                            meals.setName(comida.getComida().getNombre());
//                            meals.setPhoto_url(comida.getComida().getUrl_foto());
//                            meals.setPrice(comida.getComida().getPrecio());
//                        }
//                        productos = ordenFranquicia.getComidas()
//                        for (Productos producto : )
//                        meals.setIngredients(comida.getComida().getProductos());
//                        pedido.setMeals(ordenFranquicia.getComidas());
//
//
//                        pedido.setOrderType(TipoEnum.PEDIDO.label);
//                        pedido.set
                        Orden pedido = gson.fromJson(jsonObject.getAsJsonObject("mensaje"), Orden.class);
                        return ResponseEntity.created(null).body(new InfoResponse(HttpStatus.CREATED.value(), pedidoRepository.save(pedido), "Pedido registrado"));
                    }
                }
            case OPERADOR:
                if(jsonObject.getAsJsonObject("orderType").equals(TipoEnum.RECLAMO) || jsonObject.getAsJsonObject("orderType").equals(TipoEnum.REINTEGRO)) {
                    Orden pedido = gson.fromJson(jsonObject, Orden.class);
                    return ResponseEntity.created(null).body(new InfoResponse(HttpStatus.CREATED.value(), pedidoRepository.save(pedido), "Orden registrada"));
                }
        }
        return null;
    }
}
