package com.algamoneyFAS.api.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algamoneyFAS.api.event.RecursoCriadoEvent;

//Classe que chama o evento

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent>{

	@Override
	public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
		HttpServletResponse response = recursoCriadoEvent.getResponse();
		Long codigo = recursoCriadoEvent.getCodigo();
		adicionaHeaderLocation(response, codigo);
		
		
	}
	
	public void adicionaHeaderLocation(HttpServletResponse response, Long codigo) {
		// Retorna no Headers a URL de da categoria salva com o ID
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
		.buildAndExpand(codigo).toUri();
	    response.setHeader("Location", uri.toASCIIString());
		
	}
	
	

}
