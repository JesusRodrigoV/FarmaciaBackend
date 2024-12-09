package com.farmacia.gestion.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacia.gestion.model.HistorialVenta;
import com.farmacia.gestion.model.Producto;
import com.farmacia.gestion.repository.HistorialVentaRepository;
import com.farmacia.gestion.repository.ProductoRepository;

@Service
public class InventarioService {

    @Autowired
    private HistorialVentaRepository historialVentaRepository;
    @Autowired
    private ProductoRepository productoRepository;

    public Producto calcularEOQ(Producto producto, double costoPedido, double costoAlmacenamiento) {
        double demandaAnual = obtenerDemandaAnualReal(producto.getId());
        double eoq = Math.sqrt((2 * demandaAnual * costoPedido) / costoAlmacenamiento);

        producto.setEoq((int) Math.ceil(eoq));

        int puntoReorden = (int) (demandaAnual / 365) * 7; // Ejemplo: demanda semanal
        producto.setPuntoReorden(puntoReorden);

        return productoRepository.save(producto);
    }

    private double obtenerDemandaAnualReal(Long productoId) {
        List<HistorialVenta> ventas = historialVentaRepository.findByProductoIdAndFechaVentaBetween(
                productoId,
                LocalDate.now().minusMonths(12),
                LocalDate.now());
        return ventas.stream().mapToDouble(HistorialVenta::getCantidadVendida).sum();
    }

    public double calcularPuntoReorden(double demandaDiaria, double tiempoEntrega, double stockActual) {
        return (demandaDiaria * tiempoEntrega) + stockActual;
    }

}
