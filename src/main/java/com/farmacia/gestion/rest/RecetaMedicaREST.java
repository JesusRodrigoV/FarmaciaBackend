package com.farmacia.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.gestion.model.RecetaMedica;
import com.farmacia.gestion.service.RecetaMedicaService;



@RestController
@RequestMapping ("/recetamedica/")
public class RecetaMedicaREST {
    @Autowired
    private RecetaMedicaService recetaMedicaService;

    @GetMapping
    private ResponseEntity<List<RecetaMedica>> getAllRecetaMedica(){
        return ResponseEntity.ok(recetaMedicaService.findAll());
    }
}
