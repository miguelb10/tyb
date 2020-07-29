package com.accesorios.tyb.models.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accesorios.tyb.models.entity.Caja;
import com.accesorios.tyb.models.entity.dao.ICajaDao;

@Service
public class CajaServiceImpl implements ICajaService {

	@Autowired
	private ICajaDao cajaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Caja> findAll() {
		return cajaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Caja findById(Long id) {
		return cajaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Caja> findAll(Pageable pageable) {
		return cajaDao.findAll(pageable);
	}

	@Override
	@Transactional
	public Caja save(Caja caja) {
		return cajaDao.save(caja);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		cajaDao.deleteById(id);
	}

}
