package com.farmacia.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.gestion.model.Proveedor;
import com.farmacia.gestion.service.ProveedorService;



@RestController
@RequestMapping ("/proveedor/")
public class ProveedorREST {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    private ResponseEntity<List<Proveedor>> getAllProveedor(){
        return ResponseEntity.ok(proveedorService.findAll());
    }
}
