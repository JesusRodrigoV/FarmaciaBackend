package com.farmacia.gestion.model;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "venta")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_venta")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_venta")
	private Date fecha;
	@Column(nullable = false)
	private String cliente;
	@Column(nullable = false)
	private String metodoPago;
	@Column(nullable = false)
	private double total;
	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
	private List<DetalleVenta> detalles;

	public Venta(Date fecha, String cliente, String metodoPago, double total, List<DetalleVenta> detalles) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.metodoPago = metodoPago;
		this.total = total;
		this.detalles = detalles;
	}

	public Venta() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
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
