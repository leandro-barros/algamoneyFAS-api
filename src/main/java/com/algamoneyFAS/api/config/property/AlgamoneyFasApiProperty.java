package com.algamoneyFAS.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("algamoneyfas")
public class AlgamoneyFasApiProperty {

	private String origemPermitida = "http://localhost:8080";

	private final Seguranca seguranca = new Seguranca();

	public Seguranca getSeguranca() {
		return seguranca;
	}

	public String getOrigemPermitida() {
		return origemPermitida;
	}

	public void setOrigemPermitida(String origemPermitida) {
		this.origemPermitida = origemPermitida;
	}

	public static class Seguranca {

		private boolean enableHTTPS;

		public boolean isEnableHTTPS() {
			return enableHTTPS;
		}

		public void setEnableHTTPS(boolean enableHTTPS) {
			this.enableHTTPS = enableHTTPS;
		}

	}

}
