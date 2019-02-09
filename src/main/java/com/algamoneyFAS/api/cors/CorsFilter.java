package com.algamoneyFAS.api.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
	
	private String origemPermitida = ""; // TODO: Configurar para diferentes ambientes;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
		HttpServletResponse httpServletResponse = ((HttpServletResponse) response);
		
		httpServletResponse.setHeader("Acces-Control-Allow-Origin", origemPermitida);
		httpServletResponse.setHeader("Acces-Control-Allow-Credentials", "true");
		
		if ("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod()) && origemPermitida.equals(httpServletRequest.getHeader("Origin"))) {
			httpServletResponse.setHeader("Acces-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
			httpServletResponse.setHeader("Acces-Control-Allow-Headers", "Authorization, Content-Type, Accept");
			httpServletResponse.setHeader("Acces-Control-Max-Age", "3600");
			
			httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		}else {
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}


	@Override
	public void destroy() {
	}
	
}
