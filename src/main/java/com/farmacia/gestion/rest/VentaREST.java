package com.farmacia.gestion.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.gestion.model.Venta;
import com.farmacia.gestion.service.VentaService;

@RestController
@RequestMapping("/venta")
public class VentaREST {

    @Autowired
    private VentaService ventaService;

    @GetMapping("/all")
    private ResponseEntity<List<Venta>> getAllVenta() {
        return ResponseEntity.ok(ventaService.findAllVentas());
    }

    @GetMapping("/buscar")
    public List<Venta> buscarVentas(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return ventaService.buscarVentasPorFecha(startDate, endDate);
    }

    @GetMapping("/dia")
    public ResponseEntity<List<Venta>> obtenerPorDia(@RequestParam("fecha") String fecha) {
        LocalDate fechaConvertida = LocalDate.parse(fecha);
        return ResponseEntity.ok(ventaService.obtenerPorDia(fechaConvertida));
    }

    @GetMapping("/mes")
    public ResponseEntity<List<Venta>> obtenerPorMesYAño(
            @RequestParam("year") int year, 
            @RequestParam("month") int month) {
        return ResponseEntity.ok(ventaService.obtenerPorMesYAño(year, month));
    }

    @GetMapping("/año")
    public ResponseEntity<List<Venta>> obtenerPorAño(@RequestParam("year") int year) {
        return ResponseEntity.ok(ventaService.obtenerPorAño(year));
    }
    
    @PostMapping
    public ResponseEntity<Venta> registrarVenta(@RequestBody Venta venta) {
        return ResponseEntity.ok(ventaService.registrarVenta(venta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVenta(@PathVariable Long id) {
        return ResponseEntity.of(ventaService.obtenerVentaPorId(id));
    }
}
