package com.accesorios.tyb.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesorios.tyb.models.entity.Color;

public interface IColorDao extends JpaRepository<Color, Long>{

}
