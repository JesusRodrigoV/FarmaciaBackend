package com.farmacia.gestion.model;

import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "laboratorios")
public class Laboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laboratorio")
    private short id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    @Column(name = "id_estado")
    private Estado estado;

    @Column(name = "fecha_registro", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fecha_registro;

    public Laboratorio(String nombre, String telefono, String email, Estado estado, Timestamp fecha_registro) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
        this.fecha_registro = fecha_registro;
    }

    public Laboratorio() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setId(short id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public Estado getEstado() {
        return estado;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public short getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
}
