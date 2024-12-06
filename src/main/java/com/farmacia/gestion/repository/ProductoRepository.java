package com.farmacia.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.gestion.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreContaining(String nombre);
    List<Producto> findByCategoria(String categoria);
    List<Producto> findByLaboratorio(String laboratorio);
}
