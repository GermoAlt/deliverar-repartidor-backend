package com.uade.repartidorback.repositories;

import com.uade.repartidorback.entities.Orden;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends MongoRepository<Orden, String> {
  Optional<Orden> findById (String id);
  List<Orden> findOrdensByOrderStatus (String disponible);
  List<Orden> findOrdensByOrderType(String tipo);
  List<Orden> findOrdensByUser_IdAndOrderStatus (String idUser, String estado);
  Orden findByUser_IdAndOrderStatus (String id, String estado);

}
