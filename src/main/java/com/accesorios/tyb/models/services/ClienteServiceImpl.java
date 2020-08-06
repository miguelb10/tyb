package com.accesorios.tyb.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accesorios.tyb.models.dao.IClienteDao;
import com.accesorios.tyb.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		cliente.setDeudor(false);
		cliente.setEstado(true);
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Cliente cliente = findById(id);
		cliente.setEstado(false);
		clienteDao.save(cliente);
	}

}
