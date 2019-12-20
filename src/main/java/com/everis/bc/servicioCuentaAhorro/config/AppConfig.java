package com.everis.bc.servicioCuentaAhorro.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {
	
	@Value("${valores.uri_tc}")
	private String url;
	@Value("${valores.uri_pcorriente}")
	private String pcorriente;
	
	@Bean
	@Qualifier("tc")
	public WebClient webClientRegister() {
		return WebClient.create(url);
	}
	
	@Bean
	@Qualifier("pcorriente")
	public WebClient webClientPcorriente() {
		return WebClient.create(pcorriente);
	}
}
