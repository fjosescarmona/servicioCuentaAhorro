package com.everis.bc.servicioCuentaAhorro.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.everis.bc.servicioCuentaAhorro.model.Movimientos;

public interface RepoMovimientos extends ReactiveMongoRepository<Movimientos, String>{

}
