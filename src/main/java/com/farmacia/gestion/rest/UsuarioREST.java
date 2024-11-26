package com.farmacia.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.gestion.model.Usuario;
import com.farmacia.gestion.service.UsuarioService;


@RestController
@RequestMapping ("/usuario/")
public class UsuarioREST {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    private ResponseEntity<List<Usuario>> getAllUsuario(){
        return ResponseEntity.ok(usuarioService.findAll());
    }
}
