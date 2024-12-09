/*
package com.farmacia.gestion.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_producto")
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false)
    private String laboratorio;
    @Column(nullable = false)
    private Integer stock;
    @Column(nullable = false)
    private Double precio;
    @Column(nullable = false)
    private Date fechaVencimiento;
    /*
     * @ManyToOne
     * 
     * @JoinColumn(name = "id_proveedor", nullable = false)
     * 
     * @JsonBackReference
     * private Proveedor proveedor;
    

    public Producto(String nombre, String descripcion, Integer stock, Date fechaVencimiento, Double precio,
            String categoria) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
        this.categoria = categoria;
        // this.proveedor = proveedor;
    }

    public Producto() {
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
     * public void setProveedor(Proveedor proveedor) {
     * this.proveedor = proveedor;
     * }
     
    public int getStock() {
        return stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    /*
     * public Proveedor getProveedor() {
     * return proveedor;
     * }
     
}
     */

//Nuevo Producto mejor

package com.farmacia.gestion.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_producto")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String laboratorio;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Date fechaVencimiento;

    @Column(nullable = false)
    private String numeroLote; // Número de lote

    @Column(nullable = false)
    private Date fechaFabricacion; // Fecha de fabricación

    @Column(nullable = false)
    private String formaFarmaceutica; // Forma farmacéutica
    /*
     * @Column(nullable = false)
     * private String cantidadPresentacion; // Cantidad y presentación
     */
    @Column(nullable = false)
    private Integer puntoReorden;
    @Column(nullable = false)
    private Integer eoq; // Cantidad económica de pedido

    public Producto(String nombre, String descripcion, Integer stock, Date fechaVencimiento, Double precio,
            String categoria, String laboratorio, String numeroLote, Date fechaFabricacion, String formaFarmaceutica,
            String cantidadPresentacion) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
        this.categoria = categoria;
        this.laboratorio = laboratorio;
        this.numeroLote = numeroLote;
        this.fechaFabricacion = fechaFabricacion;
        this.formaFarmaceutica = formaFarmaceutica;
        // this.cantidadPresentacion = cantidadPresentacion;
    }

    public Producto() {
    }

    // Getters y setters adicionales
    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }
    /*
     * public String getCantidadPresentacion() {
     * return cantidadPresentacion;
     * }
     * 
     * public void setCantidadPresentacion(String cantidadPresentacion) {
     * this.cantidadPresentacion = cantidadPresentacion;
     * }
     */

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public void setEoq(Integer eoq) {
        this.eoq = eoq;
    }

    public void setPuntoReorden(Integer puntoReorden) {
        this.puntoReorden = puntoReorden;
    }

    public Integer getEoq() {
        return eoq;
    }

    public Integer getPuntoReorden() {
        return puntoReorden;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
