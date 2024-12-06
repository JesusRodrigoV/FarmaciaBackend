package com.farmacia.gestion.service;

import com.farmacia.gestion.model.Laboratorio;
import com.farmacia.gestion.repository.LaboratorioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratorioService {

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    public List<Laboratorio> getAllLaboratorios() {
        return laboratorioRepository.findAll();
    }

    public Laboratorio saveLaboratorio(Laboratorio laboratorio) {
        return laboratorioRepository.save(laboratorio);
    }

    public void deleteLaboratorio(Long id) {
        laboratorioRepository.deleteById(id);
    }

    public Laboratorio updateLaboratorio(Long id, Laboratorio laboratorio) {
        if (laboratorioRepository.existsById(id)) {
            laboratorio.setId(id);
            return laboratorioRepository.save(laboratorio);
        } else {
            throw new RuntimeException("Laboratorio no encontrado");
        }
    }

    public Laboratorio getLaboratorioById(Long id) {
        return laboratorioRepository.findById(id).orElseThrow(() -> new RuntimeException("Laboratorio no encontrado"));
    }
}
