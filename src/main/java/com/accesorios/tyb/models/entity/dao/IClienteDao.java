package com.accesorios.tyb.models.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesorios.tyb.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{

}
