package com.farmacia.gestion.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "venta")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_venta")
	private Long id;

	@Column(name = "fecha_venta", nullable = false)
	private LocalDate fecha = LocalDate.now();

	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;

	@Column(nullable = false)
	private String metodoPago;

	@Column(nullable = false)
	private double total;

	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<DetalleVenta> detalles;

	public Venta(Cliente cliente, String metodoPago, List<DetalleVenta> detalles) {
		this.cliente = cliente;
		this.metodoPago = metodoPago;
		this.detalles = detalles;
		calcularTotal();
	}

	public Venta() {
	}

	public void calcularTotal() {
		this.total = detalles.stream()
				.mapToDouble(d -> d.getCantidad() * d.getPrecioUnitario())
				.sum();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}

}
