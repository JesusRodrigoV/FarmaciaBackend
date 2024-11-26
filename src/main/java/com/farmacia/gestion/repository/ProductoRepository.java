package com.farmacia.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.gestion.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}
