package com.accesorios.tyb.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "general_settings")
public class GeneralSetting implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private String valorString;

	private Long valorLong;

	private Double valorDouble;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValorString() {
		return valorString;
	}

	public void setValorString(String valorString) {
		this.valorString = valorString;
	}

	public Long getValorLong() {
		return valorLong;
	}

	public void setValorLong(Long valorLong) {
		this.valorLong = valorLong;
	}

	public Double getValorDouble() {
		return valorDouble;
	}

	public void setValorDouble(Double valorDouble) {
		this.valorDouble = valorDouble;
	}

}
