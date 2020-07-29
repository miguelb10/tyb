package com.accesorios.tyb.models.entity.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.accesorios.tyb.models.entity.Letra;


public interface ILetraService {

	public List<Letra> findAll();
	
	public Letra findById(Long id);

	public Page<Letra> findAll(Pageable pageable);
	
	public Letra save(Letra letra);
	
	public void delete(Long id);
}
