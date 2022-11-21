package com.uade.repartidorback.services;

import com.uade.repartidorback.entities.User;
import com.uade.repartidorback.models.InfoResponse;
import com.uade.repartidorback.models.LoginRequest;
import com.uade.repartidorback.models.SignupRequest;
import com.uade.repartidorback.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;


    public ResponseEntity registrarUser (LoginRequest loginRequest){
        if (userRepository.existsByEmail(loginRequest.getUsername())) {
            return ResponseEntity.ok().body(new InfoResponse(HttpStatus.OK.value(),userRepository.findByEmail(loginRequest.getEmail()), "Usuario encontrado"));
        }
        User user = new User(loginRequest.getUsername(), loginRequest.getEmail());
        userRepository.save(user);
        return ResponseEntity.created(null).body(new InfoResponse(HttpStatus.CREATED.value(), user,"User registrado"));
    }

    @Override
    public ResponseEntity obtenerUser (String id) {
        Optional<User> user = userRepository.findById(id);
        String message = "Usuario encontrado";
        if(user.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new InfoResponse(HttpStatus.NOT_FOUND.value(), user,"Usuario no encontrado"));
        }
        return ResponseEntity.ok(new InfoResponse(HttpStatus.OK.value(),user,message));
    }

}
