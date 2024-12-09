package com.farmacia.gestion.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.gestion.model.HistorialVenta;

@Repository
public interface HistorialVentaRepository extends JpaRepository<HistorialVenta, Long>{
    List<HistorialVenta> findByProductoId(Long productoId);
    List<HistorialVenta> findByProductoIdAndFechaVentaBetween(Long productoId, LocalDate startDate, LocalDate endDate);
}
