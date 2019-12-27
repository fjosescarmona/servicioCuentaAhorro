package com.everis.bc.servicioCuentaAhorro.model;

import javax.validation.constraints.NotNull;

public class Listas {
	
	@NotNull
	private String name="";
	@NotNull
	private String lastname="";
	@NotNull
	private String doc="";
	@NotNull
	private String producto="";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}
}
