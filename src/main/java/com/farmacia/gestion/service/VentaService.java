package com.farmacia.gestion.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacia.gestion.model.DetalleVenta;

import com.farmacia.gestion.model.Venta;
import com.farmacia.gestion.repository.DetalleVentaRepository;
import com.farmacia.gestion.repository.VentaRepository;


@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;
    
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public List<DetalleVenta> findAllDetalleVentas() {
        return detalleVentaRepository.findAll();
    }

    public void deleteDetalleVenta(DetalleVenta entity) {
        detalleVentaRepository.delete(entity);
    }

    public Optional<DetalleVenta> findByIdDetalleVentas(Long id) {
        return detalleVentaRepository.findById(id);
    }

    public <S extends DetalleVenta> S saveDetalleVentas(S entity) {
        return detalleVentaRepository.save(entity);
    }

    public List<Venta> findAllVentas() {
        return ventaRepository.findAll();
    }

    public List<Venta> obtenerPorDia(LocalDate fecha) {
        return ventaRepository.findByFecha(fecha);
    }

    public List<Venta> obtenerPorMesYAño(int year, int month) {
        return ventaRepository.findByMesYAño(year, month);
    }

    public List<Venta> obtenerPorAño(int year) {
        return ventaRepository.findByAño(year);
    }

    public void deleteByIdVentas(Long id) {
        ventaRepository.deleteById(id);
    }

    public Optional<Venta> obtenerVentaPorId(Long id) {
        return ventaRepository.findById(id);
    }

    public Venta registrarVenta(Venta venta) {
        venta.calcularTotal();
        return ventaRepository.save(venta);
    }

    public List<Venta> buscarVentasPorFecha(LocalDate startDate, LocalDate endDate) {
        return ventaRepository.findByFechaBetween(startDate, endDate);
    }
}
