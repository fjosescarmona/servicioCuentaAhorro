package com.everis.bc.servicioCuentaAhorro.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection="c_movimientos")
public class Movimientos {

	@Id
	private String id;
	@NotNull
	private String nro_cuenta;
	@NotNull
	private String nro_tarjeta;
	@NotNull
	private String cuentaTo;
	@NotNull
	private String cuentaToTipo;
	@NotNull
	private String cuentaFrom;
	@NotNull
	private String descripcion;
	@NotNull
	private double monto;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	public String getCuentaTo() {
		return cuentaTo;
	}
	public void setCuentaTo(String cuentaTo) {
		this.cuentaTo = cuentaTo;
	}
	public String getCuentaToTipo() {
		return cuentaToTipo;
	}
	public void setCuentaToTipo(String cuentaToTipo) {
		this.cuentaToTipo = cuentaToTipo;
	}
	public String getCuentaFrom() {
		return cuentaFrom;
	}
	public void setCuentaFrom(String cuentaFrom) {
		this.cuentaFrom = cuentaFrom;
	}
	public String getNro_tarjeta() {
		return nro_tarjeta;
	}
	public void setNro_tarjeta(String nro_tarjeta) {
		this.nro_tarjeta = nro_tarjeta;
	}
	public String getNro_cuenta() {
		return nro_cuenta;
	}
	public void setNro_cuenta(String nro_cuenta) {
		this.nro_cuenta = nro_cuenta;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
