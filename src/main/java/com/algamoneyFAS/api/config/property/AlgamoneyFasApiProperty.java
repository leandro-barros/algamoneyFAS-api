package com.algamoneyFAS.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("algamoney")
public class AlgamoneyFasApiProperty {

//	private String origemPermitida = "http://localhost:8080";
        
        private String originPermitida = "http://localhost:8000";

	private final Seguranca seguranca = new Seguranca();

	public Seguranca getSeguranca() {
		return seguranca;
	}

    public String getOriginPermitida() {
        return originPermitida;
    }

    public void setOriginPermitida(String originPermitida) {
        this.originPermitida = originPermitida;
    }

	public static class Seguranca {

		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}

	}
//	public static class Seguranca {
//
//		private boolean enableHTTPS;
//
//		public boolean isEnableHTTPS() {
//			return enableHTTPS;
//		}
//
//		public void setEnableHTTPS(boolean enableHTTPS) {
//			this.enableHTTPS = enableHTTPS;
//		}
//
//	}

}
