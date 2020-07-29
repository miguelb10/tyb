package com.accesorios.tyb.models.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesorios.tyb.models.entity.Producto;

public interface IProductoDao extends JpaRepository<Producto, Long>{

}
