package com.accesorios.tyb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.accesorios.tyb.models.entity.Factura;
import com.accesorios.tyb.models.entity.Producto;
import com.accesorios.tyb.models.services.IFacturaService;
import com.accesorios.tyb.models.services.IProductoService;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class FacturaRestController {

	@Autowired
	private IFacturaService facturaService;

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("facturas")
	public List<Factura> index() {
		return facturaService.findAll();
	}

	@GetMapping("facturas/page/{page}")
	public Page<Factura> index(@PathVariable Integer page) {
		return facturaService.findAll(PageRequest.of(page, 5));
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("facturas/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Factura show(@PathVariable Long id) {
		return facturaService.findById(id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("facturas/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		facturaService.delete(id);
	}

	//@Secured({"ROLE_ADMIN"})
	@GetMapping("facturas/filtrar-productos/{term}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Producto> filtrarProductos(@PathVariable String term){
		return productoService.findByNombre(term);
	}

	@Secured({"ROLE_ADMIN"})
	@PostMapping("facturas")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Factura crear(@RequestBody Factura factura) {
		return facturaService.save(factura);
	}
}