package com.accesorios.tyb.models.entity.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.accesorios.tyb.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();

	public Cliente findById(Long id);

	public Page<Cliente> findAll(Pageable pageable);

	public Cliente save(Cliente cliente);

	public void delete(Long id);

}
