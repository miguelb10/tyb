package com.accesorios.tyb.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.accesorios.tyb.models.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	
	public Usuario findById(Long id);

	public Usuario findByUsername(String username);
	
	public Page<Usuario> findAll(Pageable pageable);
	
	public Usuario save(Usuario usuario);
	
	public void delete(Long id);
}
