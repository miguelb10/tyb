package com.accesorios.tyb.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accesorios.tyb.models.dao.ISerieDao;
import com.accesorios.tyb.models.entity.Serie;

@Service
public class SerieServiceImpl implements ISerieService{

	@Autowired
	private ISerieDao serieDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Serie> findAll() {
		return serieDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Serie findById(Long id) {
		return serieDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Serie> findAll(Pageable pageable) {
		return serieDao.findAll(pageable);
	}

	@Override
	@Transactional
	public Serie save(Serie serie) {
		return serieDao.save(serie);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		serieDao.deleteById(id);
	}

}
