package com.accesorios.tyb.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accesorios.tyb.models.entity.Producto;

public interface IProductoDao extends JpaRepository<Producto, Long> {

	@Query("select p from Producto p where p.nombre like %?1% and p.estado = 1")
	public List<Producto> findByNombre(String nombre);

	Page<Producto> findByEstado(Boolean estado, Pageable pageable);
	
	@Query("select SUM(precio) from Producto")
	public Double sumPrecio();
}
