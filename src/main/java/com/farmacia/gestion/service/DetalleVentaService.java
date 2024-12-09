package com.farmacia.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.farmacia.gestion.model.DetalleVenta;
import com.farmacia.gestion.repository.DetalleVentaRepository;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public List<DetalleVenta> findAll() {
        return detalleVentaRepository.findAll();
    }

    public void delete(DetalleVenta entity) {
        detalleVentaRepository.delete(entity);
    }

    public void deleteById(Long id) {
        detalleVentaRepository.deleteById(id);
    }

    public Optional<DetalleVenta> findById(Long id) {
        return detalleVentaRepository.findById(id);
    }

    public <S extends DetalleVenta> S save(S entity) {
        return detalleVentaRepository.save(entity);
    }


}
