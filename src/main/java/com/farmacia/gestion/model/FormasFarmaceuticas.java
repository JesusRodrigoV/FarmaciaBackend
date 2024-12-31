package com.farmacia.gestion.model;

import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "formas_farmaceuticas")
public class FormasFarmaceuticas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forma")
    private short id;

    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @Column(name = "fecha_registro", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fecha_registro;

    public FormasFarmaceuticas(String nombre, String descricion, Timestamp fecha_registro) {
        this.nombre = nombre;
        this.descripcion = descricion;
        this.fecha_registro = fecha_registro;
    }

    public FormasFarmaceuticas() {
    }

    public void setId(short id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
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

}
