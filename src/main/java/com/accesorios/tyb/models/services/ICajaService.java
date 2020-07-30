package com.accesorios.tyb.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.accesorios.tyb.models.entity.Caja;

public interface ICajaService {

	public List<Caja> findAll();
	
	public Caja findById(Long id);

	public Page<Caja> findAll(Pageable pageable);
	
	public Caja save(Caja caja);
	
	public void delete(Long id);
}
