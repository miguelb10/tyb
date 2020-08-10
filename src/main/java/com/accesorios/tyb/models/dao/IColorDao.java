package com.accesorios.tyb.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.accesorios.tyb.models.entity.Color;

public interface IColorDao extends JpaRepository<Color, Long>{

	Page<Color> findByEstado(Boolean estado, Pageable pageable);
}
