package com.everis.bc.servicioCuentaAhorro.service;


import java.util.List;
import java.util.Map;

import com.everis.bc.servicioCuentaAhorro.model.Deudores;
import com.everis.bc.servicioCuentaAhorro.model.CuentaAhorro;
import com.everis.bc.servicioCuentaAhorro.model.Movimientos;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceCta {
	
	public Mono<CuentaAhorro> saveData(CuentaAhorro cuenta);
	
	public Flux<CuentaAhorro> getData();
	
	public Flux<CuentaAhorro> getDataByDoc(String doc);

	public Mono<Map<String, Object>> getSaldo(String nro_cuenta);

	public Mono<Void> deleteData(String id);
	
	public Mono<CuentaAhorro> editData(String id, CuentaAhorro cuenta);
	
	public Mono<Movimientos> savePagotdc(Movimientos mov);
	
	public Mono<Movimientos> savePagoMinimotdcAhorro(Movimientos mov);
	
	public Mono<Movimientos> saveDeposito(Movimientos mov);
	
	public Mono<Movimientos> saveRetiro(Movimientos mov);
	
	public Mono<Movimientos> getTransfer(Movimientos mov);
	
	public Mono<Movimientos> setTransfer(Movimientos mov);
	
	public Flux<Movimientos> getMovimientos(String nro_cuenta);
	
	public Flux<Movimientos> getRangeMovimientos(String nro_cuenta, String from, String to);
	
	public Flux<Deudores> saveDeudoresAhorro(List<Deudores> deudores);
}
