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

import com.accesorios.tyb.models.entity.Cliente;
import com.accesorios.tyb.models.entity.Factura;
import com.accesorios.tyb.models.entity.GeneralSetting;
import com.accesorios.tyb.models.entity.Producto;
import com.accesorios.tyb.models.entity.Serie;
import com.accesorios.tyb.models.services.IClienteService;
import com.accesorios.tyb.models.services.IFacturaService;
import com.accesorios.tyb.models.services.IGeneralSettingService;
import com.accesorios.tyb.models.services.IProductoService;
import com.accesorios.tyb.models.services.ISerieService;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class FacturaRestController {

	@Autowired
	private IFacturaService facturaService;

	@Autowired
	private IProductoService productoService;

	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private ISerieService serieService;
	
	@Autowired IGeneralSettingService generalSettingService;
	
	@GetMapping("facturas")
	public Factura index() {
		//return facturaService.findAll();
		return facturaService.lastFindByCorrelativoDesc();
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

	//@Secured({"ROLE_ADMIN"})
	@GetMapping("facturas/filtrar-clientes/{term}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Cliente> filtrarClientes(@PathVariable String term){
		return clienteService.findByNombre(term);
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("facturas")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Factura crear(@RequestBody Factura factura) {
		GeneralSetting generalSettingCorrelativo = generalSettingService.findByNombre("Correlativo");
		Serie serie = serieService.findById(generalSettingService.findByNombre("Serie").getValorLong());
		factura.setCorrelativo(generalSettingCorrelativo.getValorLong());
		factura.setSerie(serie);

		generalSettingCorrelativo.setValorLong(factura.getCorrelativo()+1);
		generalSettingService.save(generalSettingCorrelativo);
		return facturaService.save(factura);
	}
}
