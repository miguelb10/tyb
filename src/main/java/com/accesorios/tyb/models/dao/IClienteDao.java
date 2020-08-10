package com.accesorios.tyb.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.accesorios.tyb.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{

	Page<Cliente> findByEstado(Boolean estado, Pageable pageable);
}
