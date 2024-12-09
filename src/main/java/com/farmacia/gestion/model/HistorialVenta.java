package com.farmacia.gestion.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class HistorialVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private int cantidadVendida;

    @Column(nullable = false)
    private LocalDate fechaVenta;

    // Constructor vacío necesario para JPA
    public HistorialVenta() {
    }

    // Constructor con parámetros
    public HistorialVenta(Producto producto, int cantidadVendida, LocalDate fechaVenta) {
        this.producto = producto;
        this.cantidadVendida = cantidadVendida;
        this.fechaVenta = fechaVenta;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}

