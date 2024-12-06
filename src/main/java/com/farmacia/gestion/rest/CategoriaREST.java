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

import com.farmacia.gestion.model.Categoria;
import com.farmacia.gestion.service.CategoriaService;

@RestController
@RequestMapping ("/categoria")
public class CategoriaREST {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getCategorias() {
        return categoriaService.getAllCategorias();
    }

    @PostMapping
    public Categoria addCategoria(@RequestBody Categoria categoria) {
        return categoriaService.saveCategoria(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCliente(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria categoriaActualizada = categoriaService.actualizarCategoria(id, categoria);
        if (categoriaActualizada != null) {
            return ResponseEntity.ok(categoriaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
    }
}
