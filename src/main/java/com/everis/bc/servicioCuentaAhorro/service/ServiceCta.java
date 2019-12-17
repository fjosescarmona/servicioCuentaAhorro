package com.everis.bc.servicioCuentaAhorro.service;


import java.util.Map;

import com.everis.bc.servicioCuentaAhorro.model.CuentaAhorro;
import com.everis.bc.servicioCuentaAhorro.model.Movimientos;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceCta {
	
	public Mono<CuentaAhorro> saveData(CuentaAhorro cuenta);
	
	public Flux<CuentaAhorro> getData();
	
	public Mono<CuentaAhorro> getDataByDoc(String doc);

	public Mono<Map<String, Object>> getSaldo(String nro_cuenta);

	public Mono<Void> deleteData(String id);
	
	public Mono<CuentaAhorro> editData(String id, CuentaAhorro cuenta);
	
	public Mono<Map<String, Object>> saveMovimiento(Movimientos mov);
	
	public Flux<Movimientos> getMovimientos(String nro_cuenta);
}
