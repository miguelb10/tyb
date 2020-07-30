package com.accesorios.tyb.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.accesorios.tyb.models.entity.Serie;

public interface ISerieService {

	public List<Serie> findAll();
	
	public Serie findById(Long id);

	public Page<Serie> findAll(Pageable pageable);
	
	public Serie save(Serie serie);
	
	public void delete(Long id);
}
