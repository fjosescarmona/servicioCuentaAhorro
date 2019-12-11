package com.everis.bc.servicioCuentaAhorro.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.everis.bc.servicioCuentaAhorro.model.CuentaAhorro;
import com.everis.bc.servicioCuentaAhorro.model.Empresa;
import com.everis.bc.servicioCuentaAhorro.model.Listas;
import com.everis.bc.servicioCuentaAhorro.model.Movimientos;
import com.everis.bc.servicioCuentaAhorro.model.Persona;
import com.everis.bc.servicioCuentaAhorro.repo.Repo;
import com.everis.bc.servicioCuentaAhorro.repo.RepoMovimientos;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceCtaImplement implements ServiceCta {

	@Autowired
	private Repo repo1;
	@Autowired
	private RepoMovimientos repoMov;
	
	//private List<String> aux;
	@Override
	public Mono<Map<String, Object>> saveData(CuentaAhorro cuenta) {
Map<String, Object> respuesta = new HashMap<String, Object>();
		
		return repo1.save(cuenta).map(cta->{
			respuesta.put("Mensaje: ", "guardado correcto");
			return  respuesta;
		});
	}

	@Override
	public Flux<CuentaAhorro> getData() {
		// TODO Auto-generated method stub
		return repo1.findAll();
	}

	@Override
	public Mono<Void> deleteData(String id) {
		// TODO Auto-generated method stub
		return repo1.findById(id).flatMap(cta->repo1.delete(cta));
	}

	@Override
	public Mono<CuentaAhorro> editData(String id, CuentaAhorro cuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Map<String, Object>> saveMovimiento(Movimientos movimiento) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		
		return repo1.findByNro_cuenta(movimiento.getNro_cuenta()).map(cta -> {
			Double saldo=cta.getSaldo();
			switch(movimiento.getDescripcion()) {
				case "retiro":{
					if(saldo>=movimiento.getMonto()) {
						cta.setSaldo(saldo-movimiento.getMonto());
						repo1.save(cta).subscribe();
						repoMov.save(movimiento).subscribe();
						respuesta.put("Result", "Retiro realizado, su nuevo saldo es: "+(saldo-movimiento.getMonto()));
						return respuesta;
					}else {
						respuesta.put("Result", "Su saldo no es suficiente para realizar la operaciòn");
						return respuesta;
					}
					
				}
				case "deposito":{
					cta.setSaldo(saldo+movimiento.getMonto());
					repo1.save(cta).subscribe();
					repoMov.save(movimiento).subscribe();
					respuesta.put("Result", "Deposito realizado, su nuevo saldo es: "+(saldo+movimiento.getMonto()));
					return respuesta;
				}
			}
			respuesta.put("Error", "Especifique el movimiento a realizar");
			return respuesta;
		});
		
		/*return repoMov.save(movimiento).map(mov->{
			respuesta.put("Mensaje: ", "ok");
			return  respuesta;
		});*/
	}

	@Override
	public Flux<Movimientos> getMovimientos() {
		// TODO Auto-generated method stub
		return repoMov.findAll();
	}

	@Override
	public Mono<CuentaAhorro> getDataByDoc(String doc) {
		// TODO Auto-generated method stub
		return repo1.findByTitularesDoc(doc);
	}

	@Override
	public Mono<Map<String, Object>> getSaldo(String nro_cuenta) {
		// TODO Auto-generated method stub
		Map<String, Object> respuesta = new HashMap<String, Object>();
		
		return repo1.findByNro_cuenta(nro_cuenta).map(cta->{
			respuesta.put("saldo", cta.getSaldo());
			return respuesta;
		});
		//return null;
	}

}
