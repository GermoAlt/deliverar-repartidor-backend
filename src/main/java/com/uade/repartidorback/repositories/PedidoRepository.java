package com.uade.repartidorback.repositories;

import com.uade.repartidorback.entities.Orden;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends MongoRepository<Orden, String> {
  Optional<Orden> findById (String id);
  List<Orden> findPedidosByStatus (String disponible);
  List<Orden> findOrdensByUser_IdAndStatus (String idUser, String estado);
  Boolean existsByNroPedido (int nroPedido);

}
