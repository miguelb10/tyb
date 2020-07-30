package com.accesorios.tyb.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.accesorios.tyb.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	
	public Producto findById(Long id);

	public Page<Producto> findAll(Pageable pageable);
	
	public Producto save(Producto producto);
	
	public void delete(Long id);
}
