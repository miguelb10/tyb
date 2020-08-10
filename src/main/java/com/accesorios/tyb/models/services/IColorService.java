package com.accesorios.tyb.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.accesorios.tyb.models.entity.Color;

public interface IColorService {

	public List<Color> findAll();
	
	public Color findById(Long id);

	public Page<Color> findAll(Pageable pageable);
	
	public Color save(Color color);
	
	public void delete(Long id);
	
	public Page<Color> findAllByEstado(Pageable pageable);
}
