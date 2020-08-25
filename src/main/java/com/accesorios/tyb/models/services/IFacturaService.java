package com.accesorios.tyb.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.accesorios.tyb.models.entity.Factura;

public interface IFacturaService {

	public List<Factura> findAll();

	public Factura lastFindByCorrelativoDesc();
	
	public Factura findById(Long id);

	public Page<Factura> findAll(Pageable pageable);
	
	public Factura save(Factura factura);
	
	public void delete(Long id);
}