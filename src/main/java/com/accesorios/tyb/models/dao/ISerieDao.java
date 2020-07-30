package com.accesorios.tyb.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesorios.tyb.models.entity.Serie;

public interface ISerieDao extends JpaRepository<Serie, Long>{

}
