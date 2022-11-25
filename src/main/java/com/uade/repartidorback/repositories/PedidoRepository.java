package com.uade.repartidorback.repositories;

import com.uade.repartidorback.entities.Orden;
import com.uade.repartidorback.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends MongoRepository<Orden, String> {
  Optional<Orden> findById (String id);
  List<Orden> findOrdensByOrderStatusAndUser (String disponible, User user);
  List<Orden> findOrdensByOrderType(String tipo);
  List<Orden> findOrdensByUser_IdAndOrderStatus (String idUser, String estado);
  Orden findByUser_IdAndOrderStatus (String id, String estado);

}
