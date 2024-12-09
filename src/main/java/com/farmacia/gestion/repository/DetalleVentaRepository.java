package com.farmacia.gestion.repository;

import com.farmacia.gestion.model.DetalleVenta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    
}