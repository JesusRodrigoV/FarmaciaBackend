package com.farmacia.gestion.service;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacia.gestion.model.HistorialVenta;
import com.farmacia.gestion.repository.HistorialVentaRepository;

@Service
public class HistorialVentaService {

    @Autowired
    private HistorialVentaRepository historialVentaRepository;

    public double[][] calcularMatrizTransicion(Long productoId) {
        List<HistorialVenta> historial = historialVentaRepository.findByProductoId(productoId);
        final double LIMITE_BAJO = 10;  // Ventas bajas
        final double LIMITE_MEDIO = 50; // Ventas medias
        int estados = 3; // Bajo, medio, alto
        double[][] matrizTransicion = new double[estados][estados];
        int[][] conteoTransiciones = new int[estados][estados];

        historial.sort((v1, v2) -> v1.getFechaVenta().compareTo(v2.getFechaVenta()));

        Integer estadoAnterior = null;
        for (HistorialVenta venta : historial) {
            int estadoActual = determinarEstado(venta.getCantidadVendida(), LIMITE_BAJO, LIMITE_MEDIO);

            if (estadoAnterior != null) {
                conteoTransiciones[estadoAnterior][estadoActual]++;
            }

            estadoAnterior = estadoActual;
        }

        for (int i = 0; i < estados; i++) {
            int sumaTransiciones = 0;
            for (int j = 0; j < estados; j++) {
                sumaTransiciones += conteoTransiciones[i][j];
            }

            if (sumaTransiciones > 0) {
                for (int j = 0; j < estados; j++) {
                    matrizTransicion[i][j] = (double) conteoTransiciones[i][j] / sumaTransiciones;
                }
            }
        }

        return matrizTransicion;
    }

    private int determinarEstado(double cantidadVendida, double limiteBajo, double limiteMedio) {
        if (cantidadVendida <= limiteBajo) {
            return 0; // Estado "Bajo"
        } else if (cantidadVendida <= limiteMedio) {
            return 1; // Estado "Medio"
        } else {
            return 2; // Estado "Alto"
        }
    }
    public List<HistorialVenta> findByProductoIdAndFechaVentaBetween(Long productoId, LocalDate startDate, LocalDate endDate){
        return historialVentaRepository.findByProductoIdAndFechaVentaBetween(productoId, startDate, endDate);
    }
    
}
