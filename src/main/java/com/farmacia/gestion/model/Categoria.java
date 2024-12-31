package com.farmacia.gestion.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

/*
 * Tabla Categorias
 */

@Entity
@Table(name = "categorias")
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_categoria")
  private int id;

  @Column(name = "nombre", nullable = false, length = 50)
  private String nombre;

  @Column(name = "descripcion", nullable = false, length = 100)
  private String descripcion;

  @Column(name = "fecha_registro", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private Timestamp fecha_registro;

  public Categoria(String nombre, String descripcion, Timestamp fecha_registro) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.fecha_registro = fecha_registro;
  }

  public Categoria() {
  }

  public void setId(int id) {
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

  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }
}
