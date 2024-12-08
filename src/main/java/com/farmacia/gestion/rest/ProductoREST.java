package com.farmacia.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.farmacia.gestion.service.ProductoService;

import com.farmacia.gestion.model.Producto;

@RestController
@RequestMapping("/producto")
public class ProductoREST {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/all")
    public ResponseEntity<List<Producto>> getAllProducto() {
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/buscar")
    public List<Producto> buscarProductos(@RequestParam(required = false) String nombre,
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String laboratorio) {
        if (nombre != null) {
            return productoService.buscarProductosPorNombre(nombre);
        } else if (categoria != null) {
            return productoService.buscarProductosPorCategoria(categoria);
        } else if (laboratorio != null) {
            return productoService.buscarProductosPorLaboratorio(laboratorio);
        }
        return List.of();
    }

    @GetMapping("/inventory")
    public ResponseEntity<ByteArrayResource> generateReport() {
        try {
            List<Producto> productos = productoService.findAll();
            byte[] report = productoService.generateInventoryReport(productos);
            ByteArrayResource resource = new ByteArrayResource(report);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=inventory_report.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(resource);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
