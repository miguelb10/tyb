package com.accesorios.tyb.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tipo_operacion")
	private String tipoOperacion;
	private String estado;
	private String descripcion;
	private String observacion;

	@Column(name = "tipo_moneda")
	private String tipoMoneda;
	private Double retencion;
	private Long correlativo;

	@Column(name = "sub_total")
	private Double subTotal;
	private Double anticipos;
	private Double descuentos;

	@Column(name = "valor_venta")
	private Double valorVenta;

	private Double isc;
	private Double igv;
	private Double icbper;

	@Column(name = "otros_cargos")
	private Double otrosCargos;

	@Column(name = "otros_tributos")
	private Double otrosTributos;

	@Column(name = "importe_total")
	private Double importeTotal;

	@Column(name = "fecha_emision")
	@Temporal(TemporalType.DATE)
	private Date fechaEmision;

	@Column(name = "hora_emision")
	@Temporal(TemporalType.TIME)
	private Date horaEmision;

	@Column(name = "fecha_vencimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaVencimiento;

	@JsonIgnoreProperties(value = { "facturas", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "factura_id")
	private List<ItemFactura> items;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "serie_id")
	private Serie serie;

	public Factura() {
		items = new ArrayList<>();
	}

	@PrePersist
	public void prePersist() {
		this.fechaEmision = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Double getAnticipos() {
		return anticipos;
	}

	public void setAnticipos(Double anticipos) {
		this.anticipos = anticipos;
	}

	public Double getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(Double descuentos) {
		this.descuentos = descuentos;
	}

	public Double getIsc() {
		return isc;
	}

	public void setIsc(Double isc) {
		this.isc = isc;
	}

	public Double getIcbper() {
		return icbper;
	}

	public void setIcbper(Double icbper) {
		this.icbper = icbper;
	}

	public Double getOtrosCargos() {
		return otrosCargos;
	}

	public void setOtrosCargos(Double otrosCargos) {
		this.otrosCargos = otrosCargos;
	}

	public Double getOtrosTributos() {
		return otrosTributos;
	}

	public void setOtrosTributos(Double otrosTributos) {
		this.otrosTributos = otrosTributos;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Long getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(Long correlativo) {
		this.correlativo = correlativo;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(Double valorVenta) {
		this.valorVenta = valorVenta;
	}

	public Double getIgv() {
		return igv;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Double getRetencion() {
		return retencion;
	}

	public void setRetencion(Double retencion) {
		this.retencion = retencion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public Date getHoraEmision() {
		return horaEmision;
	}

	public void setHoraEmision(Date horaEmision) {
		this.horaEmision = horaEmision;
	}

	/*
	 * public Double getSubTotal() { Double subTotal = 0.00; for (ItemFactura item :
	 * items) { subTotal += item.getImporte(); } return subTotal; }
	 * 
	 * public Double getValorVenta() { Double valorVenta = 0.00; valorVenta =
	 * getSubTotal() + anticipos + descuentos; return valorVenta; }
	 * 
	 * public Double getIgv() { Double igv = 0.00; igv = (getValorVenta() * 18)/100;
	 * return igv; }
	 * 
	 * public Double getImporteTotal() { Double importeTotal = 0.00; importeTotal =
	 * getValorVenta()+isc+getIgv()+icbper+otrosCargos+otrosTributos; return
	 * importeTotal; }
	 */

}
