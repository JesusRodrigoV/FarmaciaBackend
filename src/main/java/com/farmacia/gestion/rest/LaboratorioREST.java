package com.farmacia.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.gestion.model.Laboratorio;
import com.farmacia.gestion.service.LaboratorioService;

@RestController
@RequestMapping("/laboratorio")
public class LaboratorioREST {
    @Autowired
    private LaboratorioService laboratorioService;

    @GetMapping
    public List<Laboratorio> getAllLaboratorios() {
        return laboratorioService.getAllLaboratorios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratorio> getLaboratorioById(@PathVariable Long id) {
        Laboratorio laboratorio = laboratorioService.getLaboratorioById(id);
        return ResponseEntity.ok(laboratorio);
    }

    @PostMapping
    public Laboratorio saveLaboratorio(@RequestBody Laboratorio laboratorio) {
        return laboratorioService.saveLaboratorio(laboratorio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laboratorio> updateLaboratorio(@PathVariable Long id, @RequestBody Laboratorio laboratorio) {
        Laboratorio updatedLaboratorio = laboratorioService.updateLaboratorio(id, laboratorio);
        return ResponseEntity.ok(updatedLaboratorio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaboratorio(@PathVariable Long id) {
        laboratorioService.deleteLaboratorio(id);
        return ResponseEntity.noContent().build();
    }
}
