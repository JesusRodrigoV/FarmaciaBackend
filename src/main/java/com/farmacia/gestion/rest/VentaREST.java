package com.farmacia.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.gestion.model.Venta;
import com.farmacia.gestion.service.VentaService;

@RestController
@RequestMapping ("/venta/")
public class VentaREST {
    
    @Autowired
    private VentaService ventaService;

    @GetMapping
    private ResponseEntity<List<Venta>> getAllVenta(){
        return ResponseEntity.ok(ventaService.findAll());
    }
}
