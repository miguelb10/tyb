package com.accesorios.tyb.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.accesorios.tyb.models.entity.Letra;

public interface ILetraDao extends JpaRepository<Letra, Long>{

	Page<Letra> findByEstado(Boolean estado, Pageable pageable);
}
