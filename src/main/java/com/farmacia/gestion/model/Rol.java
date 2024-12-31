package com.farmacia.gestion.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private byte id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    public Rol() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}
