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

import com.accesorios.tyb.models.entity.Color;
import com.accesorios.tyb.models.services.IColorService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ColorRestController {

	@Autowired
	private IColorService colorService;
	
	@GetMapping("colors")
	public List<Color> index() {
		return colorService.findAll();
	}

	@GetMapping("colors/page/{page}")
	public Page<Color> index(@PathVariable Integer page) {
		return colorService.findAllByEstado(PageRequest.of(page, 5));
	}
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("colors/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Color color = null;
		Map<String, Object> response = new HashMap<>();
		try {
			color = colorService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (color == null) {
			response.put("mensaje", "El color ID: ".concat(id.toString().concat("no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Color>(color, HttpStatus.OK);
	}

	@Secured("ROLE_ADMIN")
	@PostMapping("colors")
	public ResponseEntity<?> create(@Valid @RequestBody Color color, BindingResult result) {
		Color colorNew = null;
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
			colorNew = colorService.save(color);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El color ha sido creado con éxito!");
		response.put("color", colorNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("colors/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Color color, BindingResult result, @PathVariable Long id) {
		Color colorActual = colorService.findById(id);
		Color colorUpdated = null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		if (colorActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el registro ID: "
					.concat(id.toString().concat("no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			colorActual.setNombre(color.getNombre());
			colorActual.setDescripcion(color.getDescripcion());

			colorUpdated = colorService.save(colorActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El color ha sido actualizado con éxito!");
		response.put("color", colorUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("colors/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			colorService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el color de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El color ha sido eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
