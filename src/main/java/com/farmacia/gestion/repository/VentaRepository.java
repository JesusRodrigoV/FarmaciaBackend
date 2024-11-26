package com.farmacia.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.gestion.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    
}
