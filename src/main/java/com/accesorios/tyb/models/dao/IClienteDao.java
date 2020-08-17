package com.accesorios.tyb.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accesorios.tyb.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{

	@Query("select p from Cliente p where p.nombre like %?1% and p.estado = 1")
	public List<Cliente> findByNombre(String nombre);
	
	Page<Cliente> findByEstado(Boolean estado, Pageable pageable);
}
