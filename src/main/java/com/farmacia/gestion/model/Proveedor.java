package com.farmacia.gestion.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_proveedor")
    private int id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String contacto;
/*
    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Producto> productos;
 */
    public Proveedor(String nombre, String contacto, List<Producto> productos) {
        super();
        this.nombre = nombre;
        this.contacto = contacto;
        //this.productos = productos;
    }

    public Proveedor() {
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/*
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
 */
    public String getContacto() {
        return contacto;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
/*
    public List<Producto> getProductos() {
        return productos;
    }
         */
}
