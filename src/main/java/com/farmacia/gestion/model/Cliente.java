package com.farmacia.gestion.model;

import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;

    @Column(name = "ci", nullable = false, length = 50)
    private String ci;

    @Column(name = "direccion", nullable = true, length = 100)
    private String direccion;

    @Column(name = "telefono", nullable = true, length = 20)
    private String telefono;

    @Column(name = "fecha_registro", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fecha_registro;

    public Cliente(String nombre, String ci, String direccion, String telefono, Timestamp fecha_registro) {
        this.nombre = nombre;
        this.ci = ci;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_registro = fecha_registro;
    }

    public Cliente() {
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFecha_registro(Timestamp fecha_registro) {
        this.fecha_registro = fecha_registro;
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

    public String getCi() {
        return ci;
    }

    public String getDireccion() {
        return direccion;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public Long getId() {
        return id;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }
}
