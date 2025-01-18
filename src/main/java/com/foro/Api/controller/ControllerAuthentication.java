package com.foro.Api.controller;


import com.foro.Api.DTO.dtoAuthentication.LoginUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class ControllerAuthentication {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<ControllerAuthentication> authenticateUser(@RequestBody @Valid LoginUser loginUser){
        Authentication token = new UsernamePasswordAuthenticationToken(loginUser.correo(),loginUser.password());
        authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}


