package com.farmacia.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacia.gestion.model.RecetaMedica;
import com.farmacia.gestion.repository.RecetaMedicaRepository;

@Service
public class RecetaMedicaService{
    @Autowired
    private RecetaMedicaRepository recetaMedicaRepository;

    public List<RecetaMedica> findAll() {
        return recetaMedicaRepository.findAll();
    }

    public void delete(RecetaMedica entity) {
        recetaMedicaRepository.delete(entity);
    }

    public void deleteById(Long id) {
        recetaMedicaRepository.deleteById(id);
    }

    public Optional<RecetaMedica> findById(Long id) {
        return recetaMedicaRepository.findById(id);
    }

    public <S extends RecetaMedica> S save(S entity) {
        return recetaMedicaRepository.save(entity);
    }

}
