package com.farmacia.gestion.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_detalle")
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private double precio;

    public DetalleVenta(Venta venta, Producto producto, int cantidad, double precio) {
        super();
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public DetalleVenta() {
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public Venta getVenta() {
        return venta;
    }
}
