package com.everis.bc.servicioCuentaAhorro.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection="c_cahorro")
public class CuentaAhorro {
	@Id
	private String id;
	@NotNull
	private String bankcode="";
	@NotNull
	private String bank="";
	@NotNull
	private String nro_cuenta="";
	@NotNull
	private String tipo="";
	@NotNull
	private double saldo=0;
	@NotNull
	private int movesxmonth;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lastmove;
	
	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getMovesxmonth() {
		return movesxmonth;
	}

	public void setMovesxmonth(int movesxmonth) {
		this.movesxmonth = movesxmonth;
	}

	public Date getLastmove() {
		return lastmove;
	}

	public void setLastmove(Date lastmove) {
		this.lastmove = lastmove;
	}

	private List<Listas> titulares;
	
	private List<Listas> firmantes;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNro_cuenta() {
		return nro_cuenta;
	}

	public void setNro_cuenta(String nro_cuenta) {
		this.nro_cuenta = nro_cuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<Listas> getTitulares() {
		return titulares;
	}

	public void setTitulares(List<Listas> titulares) {
		this.titulares = titulares;
	}

	public List<Listas> getFirmantes() {
		return firmantes;
	}

	public void setFirmantes(List<Listas> firmantes) {
		this.firmantes = firmantes;
	}


}
