package com.farmacia.gestion.service;

import com.farmacia.gestion.model.Categoria;
import com.farmacia.gestion.model.Cliente;
import com.farmacia.gestion.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

     public Categoria actualizarCategoria(Long id, Categoria categoria) {
        if (categoriaRepository.existsById(id)) {
            categoria.setId(id);
            return categoriaRepository.save(categoria);
        }
        return null;
    }

    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
