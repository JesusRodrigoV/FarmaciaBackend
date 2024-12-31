package com.farmacia.gestion.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estados")
public class Estado {

    public enum Tipo {
        ACTIVO,
        INACTIVO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "descripcion", nullable = false, length = 15)
    private Tipo descripcion;

    public Estado(Tipo descripcion){
        this.descripcion = descripcion;
    }
    
    public Estado(){}

    public void setDescripcion(Tipo descripcion) {
        this.descripcion = descripcion;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Tipo getDescripcion() {
        return descripcion;
    }
    public Long getId() {
        return id;
    }

}
