package com.accesorios.tyb.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesorios.tyb.models.entity.Factura;

public interface IFacturaDao extends JpaRepository<Factura, Long>{
	List<Factura> findAllByOrderByCorrelativoDesc();
}
