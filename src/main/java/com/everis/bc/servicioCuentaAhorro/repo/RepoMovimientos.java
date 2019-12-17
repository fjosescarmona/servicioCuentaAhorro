package com.everis.bc.servicioCuentaAhorro.repo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.everis.bc.servicioCuentaAhorro.model.Movimientos;

import reactor.core.publisher.Flux;

public interface RepoMovimientos extends ReactiveMongoRepository<Movimientos, String>{

	@Query("{ 'nro_cuenta': ?0 }")
	public Flux<Movimientos> findByNro_cuenta(String nro_cuenta);
}
