package com.farmacia.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacia.gestion.model.Proveedor;
import com.farmacia.gestion.repository.ProveedorRepository;

@Service
public class ProveedorService{
    @Autowired
    private  ProveedorRepository proveedorRepository;

    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    public void delete(Proveedor entity) {
        proveedorRepository.delete(entity);
    }

    public void deleteById(Long id) {
        proveedorRepository.deleteById(id);
    }

    public Optional<Proveedor> findById(Long id) {
        return proveedorRepository.findById(id);
    }

    public <S extends Proveedor> S save(S entity) {
        return proveedorRepository.save(entity);
    }

    
}
