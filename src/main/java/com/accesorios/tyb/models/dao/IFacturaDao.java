package com.accesorios.tyb.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accesorios.tyb.models.entity.Factura;

public interface IFacturaDao extends JpaRepository<Factura, Long>{
	List<Factura> findAllByOrderByCorrelativoDesc();
	
	@Query("select SUM(importeTotal) from Factura")
	public Double totalFacturado();
}
