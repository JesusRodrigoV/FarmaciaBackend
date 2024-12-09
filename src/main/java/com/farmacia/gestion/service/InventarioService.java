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
        System.out.println("Empezando EOQ");
        double demandaAnual = obtenerDemandaAnualReal(producto.getId());
        double eoq = Math.sqrt((2 * demandaAnual * costoPedido) / costoAlmacenamiento);
        producto.setEoq((int) Math.ceil(eoq));
        calcularPuntoReorden(producto, producto.getTiempoEntrega(), producto.getStockSeguridad());
        return productoRepository.save(producto);
    }

    private double obtenerDemandaAnualReal(Long productoId) {
        List<HistorialVenta> ventas = historialVentaRepository.findByProductoIdAndFechaVentaBetween(
                productoId,
                LocalDate.now().minusMonths(12),
                LocalDate.now());
        return ventas.stream().mapToDouble(HistorialVenta::getCantidadVendida).sum();
    }

    private void calcularPuntoReorden(Producto producto, double tiempoEntrega, double stockSeguridad) {
        double demandaDiaria = obtenerDemandaAnualReal(producto.getId()) / 365;
        System.out.println("\n\n\n\nLa demanda diaria: "+demandaDiaria);
        int puntoReorden = (int) Math.ceil((demandaDiaria * tiempoEntrega) + stockSeguridad);
        System.out.println("\\n" + //
                        "\\n" + //
                        "\\n" + //
                        "\\n" + //
                        "El punto de reorden: "+puntoReorden);
        producto.setPuntoReorden(puntoReorden);
    }

    

}
