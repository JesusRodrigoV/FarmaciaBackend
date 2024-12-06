package com.farmacia.gestion.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacia.gestion.repository.ProductoRepository;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import java.util.List;
import java.util.Map;
import com.farmacia.gestion.model.Producto;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> buscarProductosPorNombre(String nombre) {
        return productoRepository.findByNombreContaining(nombre);
    }

    public List<Producto> buscarProductosPorCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    public List<Producto> buscarProductosPorLaboratorio(String laboratorio) {
        return productoRepository.findByLaboratorio(laboratorio);
    }

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public byte[] generateInventoryReport(List<Producto> productos) throws JRException {
        String reportPath = "src/main/resources/reports/inventory_report.jrxml";
        JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productos);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "JR - Axl y sus Amigos");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

}
