package com.everis.bc.servicioCuentaAhorro.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.everis.bc.servicioCuentaAhorro.model.CuentaAhorro;
import com.everis.bc.servicioCuentaAhorro.model.Deudores;

import reactor.core.publisher.Flux;


public interface RepoD extends ReactiveMongoRepository<Deudores, String>{
	@Query("{ 'documento': {$in:[ ?0 ]} }")
	public Flux<CuentaAhorro> findByTitularesDocList(List<String> docs);
}
