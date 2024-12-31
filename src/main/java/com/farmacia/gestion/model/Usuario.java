package com.farmacia.gestion.model;

import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "usuario", nullable = false, length = 255)
    private String usuario;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "fecha_registro", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fecha_registro;

    @OneToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    public Usuario(String usuario, String password, Timestamp fecha_registro, Rol rol) {
        this.usuario = usuario;
        this.password = password;
        this.fecha_registro = fecha_registro;
        this.rol = rol;

    }

    public Usuario() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Rol getRol() {
        return rol;
    }

    public String getUsuario() {
        return usuario;
    }

}
