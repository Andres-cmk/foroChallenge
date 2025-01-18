package com.foro.Api.controller;


import com.foro.Api.DTO.dtoAuthentication.JWToken;
import com.foro.Api.DTO.dtoAuthentication.LoginUser;
import com.foro.Api.entities.Usuario;
import com.foro.Api.repository.UsuarioRepository;
import com.foro.Api.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class ControllerAuthentication {


    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;


    public ControllerAuthentication(AuthenticationManager authenticationManager, TokenService tokenService,
                                    UsuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid LoginUser loginUser){
        Authentication token = new UsernamePasswordAuthenticationToken(loginUser.correo(),loginUser.password());
        var authenticated  = authenticationManager.authenticate(token);
        var userDatils = (UserDetails)authenticated.getPrincipal();

        Optional<Usuario> usuario = usuarioRepository.findByCorreo(userDatils.getUsername());

        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
        }

        var JWTtoken = tokenService.generateToken(usuario.get());

        return ResponseEntity.ok(new JWToken(JWTtoken));
    }
}


