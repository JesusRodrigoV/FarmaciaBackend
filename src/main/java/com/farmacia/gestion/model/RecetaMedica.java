package com.farmacia.gestion.model;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "receta_medica")
public class RecetaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta")
    private int id;
    @Column(nullable = false)
    private String paciente;
    @Column(name = "fecha_prescripcion", nullable = false)
    private Date fechaPrescripcion;
    @Column(nullable = false)
    private String medico;
    @ManyToMany
    @JoinTable(name = "receta_producto", joinColumns = @JoinColumn(name = "id_receta"), inverseJoinColumns = @JoinColumn(name = "id_producto"))
    private List<Producto> medicamentos;

    public RecetaMedica(String paciente, Date fechaPrescripcion, String medico, List<Producto> medicamentos) {
        super();
        this.paciente = paciente;
        this.fechaPrescripcion = fechaPrescripcion;
        this.medico = medico;
        this.medicamentos = medicamentos;
    }
    public RecetaMedica(){}

    public void setFechaPrescripcion(Date fechaPrescripcion) {
        this.fechaPrescripcion = fechaPrescripcion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMedicamentos(List<Producto> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public Date getFechaPrescripcion() {
        return fechaPrescripcion;
    }

    public int getId() {
        return id;
    }

    public List<Producto> getMedicamentos() {
        return medicamentos;
    }

    public String getMedico() {
        return medico;
    }

    public String getPaciente() {
        return paciente;
    }
}
