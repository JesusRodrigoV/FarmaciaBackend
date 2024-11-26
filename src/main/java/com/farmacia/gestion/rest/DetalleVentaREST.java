package com.farmacia.gestion.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.gestion.service.DetalleVentaService;
import com.farmacia.gestion.model.DetalleVenta;
@RestController
@RequestMapping ("/detalleventa/")
public class DetalleVentaREST {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    private ResponseEntity<List<DetalleVenta>> getAllDetalleVenta(){
        return ResponseEntity.ok(detalleVentaService.findAll());
    }

    @PostMapping
    private ResponseEntity<DetalleVenta> saveDetalleVenta(@RequestBody DetalleVenta detalleVenta){
        try {
            DetalleVenta detalleVentaGuardado = detalleVentaService.save(detalleVenta);
            return ResponseEntity.created(new URI("/detalleventa/" + detalleVentaGuardado.getId())).body(detalleVentaGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
        }
    }
}
