package com.farmacia.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacia.gestion.model.Usuario;
import com.farmacia.gestion.repository.UsuarioRepository;

@Service
public class UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public void delete(Usuario entity) {
        usuarioRepository.delete(entity);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> findById(Long id) {
       return usuarioRepository.findById(id);
    }

    public <S extends Usuario> S save(S entity) {
        return usuarioRepository.save(entity);
    }
}
