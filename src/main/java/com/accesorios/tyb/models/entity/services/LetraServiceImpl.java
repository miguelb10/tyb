package com.accesorios.tyb.models.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accesorios.tyb.models.entity.Letra;
import com.accesorios.tyb.models.entity.dao.ILetraDao;

@Service
public class LetraServiceImpl implements ILetraService{

	@Autowired
	private ILetraDao letraDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Letra> findAll() {
		return letraDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Letra findById(Long id) {
		return letraDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Letra> findAll(Pageable pageable) {
		return letraDao.findAll(pageable);
	}

	@Override
	@Transactional
	public Letra save(Letra letra) {
		return letraDao.save(letra);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		letraDao.deleteById(id);
	}

}
