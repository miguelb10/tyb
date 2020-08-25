package com.accesorios.tyb.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accesorios.tyb.models.dao.IFacturaDao;
import com.accesorios.tyb.models.entity.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaDao facturaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Factura> findAll() {
		return facturaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Factura findById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Factura> findAll(Pageable pageable) {
		return facturaDao.findAll(pageable);
	}

	@Override
	@Transactional
	public Factura save(Factura factura) {
		factura.setTipoOperacion("Factura");
		return facturaDao.save(factura);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		facturaDao.deleteById(id);
	}

	@Override
	public Factura lastFindByCorrelativoDesc() {
		try {
			return facturaDao.findAllByOrderByCorrelativoDesc().get(0);
		} catch (Exception e) {
			return new Factura();
		}
	}

}
