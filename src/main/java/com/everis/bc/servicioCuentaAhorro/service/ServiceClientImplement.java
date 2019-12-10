package com.everis.bc.servicioCuentaAhorro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.everis.bc.servicioCuentaAhorro.model.Persona;

import reactor.core.publisher.Mono;

@Service
public class ServiceClientImplement implements ServiceClient{

	@Autowired
	WebClient client;
	
	@Override
	public Mono<Persona> saveData(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
