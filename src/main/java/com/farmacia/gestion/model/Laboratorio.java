package com.farmacia.gestion.model;

import jakarta.persistence.*;

@Entity
@Table(name = "laboratorio")
public class Laboratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String ubicacion;

    public Laboratorio(Long id, String nombre, String ubicacion){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
    public Laboratorio(){}
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getUbicacion() {
        return ubicacion;
    }
}

