package com.accesorios.tyb.models.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesorios.tyb.models.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{

}
