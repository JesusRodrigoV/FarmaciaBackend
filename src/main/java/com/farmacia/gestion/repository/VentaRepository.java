package com.farmacia.gestion.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.farmacia.gestion.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    List<Venta> findByFechaBetween(LocalDate startDate, LocalDate endDate);

    // Ventas por día
    @Query("SELECT v FROM Venta v WHERE v.fecha = :fecha")
    List<Venta> findByFecha(@Param("fecha") LocalDate fecha);

    // Ventas por mes y año
    @Query("SELECT v FROM Venta v WHERE YEAR(v.fecha) = :year AND MONTH(v.fecha) = :month")
    List<Venta> findByMesYAño(@Param("year") int year, @Param("month") int month);

    // Ventas por año
    @Query("SELECT v FROM Venta v WHERE YEAR(v.fecha) = :year")
    List<Venta> findByAño(@Param("year") int year);
}
