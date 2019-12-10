package com.everis.bc.servicioCuentaAhorro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Value("${config.base.personaClient}")
	private String url;
	
	@Bean
	public WebClient servicioPersonaClient() {
		return WebClient.create(url);
	}
}
