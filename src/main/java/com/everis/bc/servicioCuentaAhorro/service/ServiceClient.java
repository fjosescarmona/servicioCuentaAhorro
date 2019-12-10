package com.everis.bc.servicioCuentaAhorro.service;

import com.everis.bc.servicioCuentaAhorro.model.Persona;

import reactor.core.publisher.Mono;

public interface ServiceClient {
	public Mono<Persona> saveData(Persona persona);
}
