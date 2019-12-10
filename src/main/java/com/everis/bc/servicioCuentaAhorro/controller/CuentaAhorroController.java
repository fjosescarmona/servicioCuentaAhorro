package com.everis.bc.servicioCuentaAhorro.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.bc.servicioCuentaAhorro.model.CuentaAhorro;
import com.everis.bc.servicioCuentaAhorro.model.Movimientos;
import com.everis.bc.servicioCuentaAhorro.service.ServiceCta;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CuentaAhorroController {

	@Autowired
	private ServiceCta s_cuenta;

	@PostMapping("/saveCAhorroData")
	public Mono<Map<String, Object>> saveCAhorroData(@RequestBody CuentaAhorro cuenta){
		return s_cuenta.saveData(cuenta);
	}
	
	@GetMapping("/getCAhorroData/{doc}")
	public Mono<CuentaAhorro> getCAhorroData(@PathVariable("doc") String doc){
		return s_cuenta.getDataByDoc(doc);
	}
	
	@GetMapping("/getCAhorroSaldo/{nro_cuenta}")
	public Mono<Map<String, Object>> getCAhorroSaldo(@PathVariable("nro_cuenta") String nro_cuenta){
		return s_cuenta.getSaldo(nro_cuenta);
	}
	
	@PostMapping("/saveMovimientosAhorro")
	public Mono<Map<String, Object>> saveMovimientosAhorro(@RequestBody Movimientos movimiento){
		return s_cuenta.saveMovimiento(movimiento);
	}
	
	@GetMapping("/getMovimientosAhorro")
	public Flux<Movimientos> getMovimientosAhorro(){
		return s_cuenta.getMovimientos();
	}

}
