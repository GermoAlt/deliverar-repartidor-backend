package com.uade.repartidorback.repositories;

import com.uade.repartidorback.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findByUsername(String username);

  Optional<User> findByEmail(String email);

  Boolean existsByEmail(String email);

  Optional<User> findById (String id);
}
