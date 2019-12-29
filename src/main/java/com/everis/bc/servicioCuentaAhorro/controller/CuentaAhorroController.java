package com.everis.bc.servicioCuentaAhorro.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.bc.servicioCuentaAhorro.model.Deudores;
import com.everis.bc.servicioCuentaAhorro.model.CuentaAhorro;
import com.everis.bc.servicioCuentaAhorro.model.Movimientos;
import com.everis.bc.servicioCuentaAhorro.service.ServiceCta;

import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CuentaAhorroController {

	@Autowired
	private ServiceCta s_cuenta;

	@PostMapping("/saveCAhorroData")
	public Mono<CuentaAhorro> saveCAhorroData(@RequestBody CuentaAhorro cuenta){
		return s_cuenta.saveData(cuenta);
	}
	
	@GetMapping("/getCAhorroData/{doc}")
	public Flux<CuentaAhorro> getCAhorroData(@PathVariable("doc") String doc){
		return s_cuenta.getDataByDoc(doc);
	}
	
	@GetMapping("/getCAhorroSaldo/{nro_cuenta}")
	public Mono<Map<String, Object>> getCAhorroSaldo(@PathVariable("nro_cuenta") String nro_cuenta){
		return s_cuenta.getSaldo(nro_cuenta);
	}
	
	
	@GetMapping("/getMovimientosAhorro/{nro_cuenta}")
	public Flux<Movimientos> getMovimientosAhorro(@PathVariable("nro_cuenta") String nro_cuenta){
		return s_cuenta.getMovimientos(nro_cuenta);
	}
	
	@PostMapping("/savePagotdcAhorro")
	public Mono<Movimientos> savePagotdcAhorro(@RequestBody Movimientos movimiento){
		return s_cuenta.savePagotdc(movimiento);
	}
	
	@PostMapping("/saveDepositoAhorro")
	public Mono<Movimientos> saveDepositoAhorro(@RequestBody Movimientos movimiento){
		return s_cuenta.saveDeposito(movimiento);
	}
	
	@PostMapping("/saveRetiroAhorro")
	public Mono<Movimientos> saveRetiroAhorro(@RequestBody Movimientos movimiento){
		return s_cuenta.saveRetiro(movimiento);
	}
	
	@PostMapping("/getTransferAhorro")
	public Mono<Movimientos> getTransferAhorro(@RequestBody Movimientos movimiento){
		return s_cuenta.getTransfer(movimiento);
	}
	
	@PostMapping("/setTransferAhorro")
	public Mono<Movimientos> setTransferAhorro(@RequestBody Movimientos movimiento){
		return s_cuenta.setTransfer(movimiento);
	}
	
	@GetMapping("/getRangeMovimientosAhorro/{nro_cuenta}/{from}/{to}")
	public Flux<Movimientos> getRangeMovimientosAhorro(@PathVariable("nro_cuenta") String nro_cuenta, @PathVariable("from") String from, @PathVariable("to") String to){
		return s_cuenta.getRangeMovimientos(nro_cuenta, from, to);
	}
	
	@PostMapping("/saveDeudoresAhorro")
	public Flux<Deudores> saveDeudoresAhorro(@RequestBody List<Deudores> deudores){
		return s_cuenta.saveDeudoresAhorro(deudores);
	}

}
