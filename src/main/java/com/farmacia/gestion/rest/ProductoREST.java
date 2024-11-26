package com.farmacia.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.gestion.model.Producto;
import com.farmacia.gestion.service.ProductoService;

@RestController
@RequestMapping ("/producto/")
public class ProductoREST {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping
    private ResponseEntity<List<Producto>> getAllProducto(){
        return ResponseEntity.ok(productoService.findAll());
    }
}
