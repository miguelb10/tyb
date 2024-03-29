package com.accesorios.tyb.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accesorios.tyb.models.dao.IColorDao;
import com.accesorios.tyb.models.entity.Color;

@Service
public class ColorServiceImpl implements IColorService {

	@Autowired
	private IColorDao colorDao;

	@Override
	@Transactional(readOnly = true)
	public List<Color> findAll() {
		return colorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Color findById(Long id) {
		return colorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Color> findAll(Pageable pageable) {
		return colorDao.findAll(pageable);
	}

	@Override
	@Transactional
	public Color save(Color color) {
		return colorDao.save(color);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Color color = findById(id);
		color.setEstado(false);
		colorDao.save(color);
	}

	@Override
	public Page<Color> findAllByEstado(Pageable pageable) {	
		return colorDao.findByEstado(true, pageable);
	}

}
