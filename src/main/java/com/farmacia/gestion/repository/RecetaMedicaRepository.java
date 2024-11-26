package com.farmacia.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.gestion.model.RecetaMedica;

@Repository
public interface RecetaMedicaRepository extends JpaRepository<RecetaMedica, Long> {
    
}
