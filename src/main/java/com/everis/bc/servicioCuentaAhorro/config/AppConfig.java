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
	@Value("${valores.uri_ecorriente}")
	private String ecorriente;
	@Value("${valores.uri_vip}")
	private String vip;
	@Value("${valores.uri_ahorro}")
	private String ahorro;
	@Value("${valores.uri_info}")
	private String info;
	
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
	
	@Bean
	@Qualifier("ecorriente")
	public WebClient webClientEcorriente() {
		return WebClient.create(ecorriente);
	}
	@Bean
	@Qualifier("vip")
	public WebClient webClientVip() {
		return WebClient.create(vip);
	}
	
	@Bean
	@Qualifier("ahorro")
	public WebClient webClientAhorro() {
		return WebClient.create(ahorro);
	}
	
	@Bean
	@Qualifier("info")
	public WebClient webClientInfo() {
		return WebClient.create(info);
	}
}
