package com.everis.bc.servicioCuentaAhorro.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.everis.bc.servicioCuentaAhorro.model.CuentaAhorro;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Repo extends ReactiveMongoRepository<CuentaAhorro, String>{
	@Query("{ 'titulares.doc': ?0 }")
	public Flux<CuentaAhorro> findByTitularesDoc(String doc);
	@Query("{ 'nro_cuenta': ?0 }")
	public Mono<CuentaAhorro> findByNro_cuenta(String nro_cuenta);
	@Query("{ 'titulares.doc': {$in:[ ?0 ]}, 'bankcode': ?1 }")
	public Flux<CuentaAhorro> findByTitularesDocList(List<String> docs, String bankcode);
	//public boolean existByTitulares(String doc);
}
