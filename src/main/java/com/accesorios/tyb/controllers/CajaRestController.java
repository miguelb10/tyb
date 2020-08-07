package com.accesorios.tyb.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accesorios.tyb.models.entity.Caja;
import com.accesorios.tyb.models.services.ICajaService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class CajaRestController {
	@Autowired
	private ICajaService cajaService;
	
	@GetMapping("cajas")
	public List<Caja> index() {
		return cajaService.findAll();
	}

	@GetMapping("cajas/page/{page}")
	public Page<Caja> index(@PathVariable Integer page) {
		return cajaService.findAll(PageRequest.of(page, 5));
	}
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("cajas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Caja caja = null;
		Map<String, Object> response = new HashMap<>();
		try {
			caja = cajaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (caja == null) {
			response.put("mensaje", "El registro ID: ".concat(id.toString().concat("no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Caja>(caja, HttpStatus.OK);
	}

	@Secured("ROLE_ADMIN")
	@PostMapping("cajas")
	public ResponseEntity<?> create(@Valid @RequestBody Caja caja, BindingResult result) {
		Caja cajaNew = null;
		Map<String, Object> response = new HashMap<>();
		List<String> errors = new ArrayList<String>();

		if (result.hasErrors()) {
			errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			cajaNew = cajaService.save(caja);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El registro ha sido creado con éxito!");
		response.put("caja", cajaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("cajas/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Caja caja, BindingResult result, @PathVariable Long id) {
		Caja cajaActual = cajaService.findById(id);
		Caja cajaUpdated = null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		if (cajaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el registro ID: "
					.concat(id.toString().concat("no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			cajaActual.setMotivo(caja.getMotivo());
			cajaActual.setResponsable(caja.getResponsable());
			cajaActual.setDescripcion(caja.getDescripcion());
			cajaActual.setTipo(caja.getTipo());
			cajaActual.setMonto(caja.getMonto());
			cajaActual.setSaldo(caja.getSaldo());

			cajaUpdated = cajaService.save(cajaActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El registro ha sido actualizado con éxito!");
		response.put("caja", cajaUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("cajas/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			cajaService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el registro de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El registro ha sido eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
