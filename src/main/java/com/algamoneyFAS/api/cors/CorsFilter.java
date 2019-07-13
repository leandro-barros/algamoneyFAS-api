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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.algamoneyFAS.api.config.property.AlgamoneyFasApiProperty;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
	
//	private String origemPermitida = ""; // TODO: Configurar para diferentes ambientes;

	@Autowired
	private AlgamoneyFasApiProperty algamoneyFasApiProperty;
        
        @Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		response.setHeader("Access-Control-Allow-Origin", algamoneyFasApiProperty.getOriginPermitida());
        response.setHeader("Access-Control-Allow-Credentials", "true");
		
		if ("OPTIONS".equals(request.getMethod()) && algamoneyFasApiProperty.getOriginPermitida().equals(request.getHeader("Origin"))) {
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
        	response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
        	response.setHeader("Access-Control-Max-Age", "3600");
			
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(req, resp);
		}
		
	}
	
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
//		HttpServletResponse httpServletResponse = ((HttpServletResponse) response);
//		
//		httpServletResponse.setHeader("Acces-Control-Allow-Origin", algamoneyFasApiProperty.getOriginPermitida());
//		httpServletResponse.setHeader("Acces-Control-Allow-Credentials", "true");
//		
//		if ("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod()) && algamoneyFasApiProperty.getOriginPermitida().equals(httpServletRequest.getHeader("Origin"))) {
//			httpServletResponse.setHeader("Acces-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
//			httpServletResponse.setHeader("Acces-Control-Allow-Headers", "Authorization, Content-Type, Accept");
//			httpServletResponse.setHeader("Acces-Control-Max-Age", "3600");
//			
//			httpServletResponse.setStatus(HttpServletResponse.SC_OK);
//		}else {
//			chain.doFilter(request, response);
//		}
//	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}


	@Override
	public void destroy() {
	}
	
}
