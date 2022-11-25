package com.uade.repartidorback.services;

import com.uade.repartidorback.entities.Orden;
import com.uade.repartidorback.entities.User;
import com.uade.repartidorback.enums.EstadoEnum;
import com.uade.repartidorback.models.InfoResponse;
import com.uade.repartidorback.models.LoginRequest;
import com.uade.repartidorback.repositories.PedidoRepository;
import com.uade.repartidorback.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public ResponseEntity obtenerPedidos () {
        List<Orden> pedidosDisponibles = pedidoRepository.findOrdensByOrderStatus(EstadoEnum.RETIRAR.name());
        String message = "Pedidos encontrados";
        if(pedidosDisponibles.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new InfoResponse(HttpStatus.NOT_FOUND.value(), pedidosDisponibles,"No hay pedidos disponibles"));
        }
        return ResponseEntity.ok(new InfoResponse(HttpStatus.OK.value(),pedidosDisponibles,message));
    }

    @Override
    public ResponseEntity obtenerOrdenesCompletadas(String idUser, String estado) {
        List<Orden> ordenes = pedidoRepository.findOrdensByUser_IdAndOrderStatus(idUser, EstadoEnum.ENTREGADO.name());
        String message = "Pedidos encontrados";
        if(ordenes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new InfoResponse(HttpStatus.NOT_FOUND.value(), ordenes,"No hay pedidos disponibles"));
        }
        return ResponseEntity.ok(new InfoResponse(HttpStatus.OK.value(),ordenes,message));
    }

    @Override
    public ResponseEntity nuevoPedidoEnCurso(Orden orden) {
        Optional<Orden> pedidoARetirar = pedidoRepository.findById(orden.getId());
        pedidoARetirar.get().setOrderStatus(orden.getOrderStatus());
        User repartidor = new User();
        repartidor.setId(orden.getUser().getId());
        repartidor.setUsername(orden.getUser().getUsername());
        pedidoARetirar.get().setUser(repartidor);
        pedidoRepository.save(pedidoARetirar.get());
        return ResponseEntity.created(null).body(new InfoResponse(HttpStatus.CREATED.value(), orden,"Orden registrada"));
    }

    @Override
    public ResponseEntity updatePedidoEnCurso(Orden orden) {
        Optional<Orden> pedidoARetirar = pedidoRepository.findById(orden.getId());
        pedidoARetirar.get().setOrderStatus(orden.getOrderStatus());
        pedidoRepository.save(pedidoARetirar.get());
        return ResponseEntity.created(null).body(new InfoResponse(HttpStatus.CREATED.value(), orden,"Orden modificada"));
    }

}
