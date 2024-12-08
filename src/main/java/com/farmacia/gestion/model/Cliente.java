package com.farmacia.gestion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    private String email;

    public Cliente(Long id, String nombre, String direccion, String telefono, String email){
        this.direccion = direccion;
        this.email = email;
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public Cliente(){
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getEmail() {
        return email;
    }public Long getId() {
        return id;
    }public String getNombre() {
        return nombre;
    }public String getTelefono() {
        return telefono;
    }
    

}
