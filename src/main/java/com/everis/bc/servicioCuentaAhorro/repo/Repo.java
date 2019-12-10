package com.everis.bc.servicioCuentaAhorro.repo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.everis.bc.servicioCuentaAhorro.model.CuentaAhorro;
import reactor.core.publisher.Mono;

public interface Repo extends ReactiveMongoRepository<CuentaAhorro, String>{
	@Query("{ 'titulares.doc': ?0 }")
	public Mono<CuentaAhorro> findByTitularesDoc(String doc);
	@Query("{ 'nro_cuenta': ?0 }")
	public Mono<CuentaAhorro> findByNro_cuenta(String nro_cuenta);
	
	//public boolean existByTitulares(String doc);
}
