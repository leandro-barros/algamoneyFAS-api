package com.algamoneyFAS.api.token;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.algamoneyFAS.api.config.property.AlgamoneyFasApiProperty;

// Classe pega o refresh_token e adiciona em um Cooke para o javaScript não ter acesso ao refreshToken.

//@Profile("oauth-security")
@ControllerAdvice
public class RefreshTokenPostProcessor implements ResponseBodyAdvice<OAuth2AccessToken>{

	@Autowired
	private AlgamoneyFasApiProperty algamoneyFasApiProperty;
	
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return returnType.getMethod().getName().equals("postAccessToken");
	}

	@Override
	public OAuth2AccessToken beforeBodyWrite(OAuth2AccessToken body, MethodParameter returnType,
			MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
			ServerHttpRequest request, ServerHttpResponse response) {
		
		DefaultOAuth2AccessToken tokenBody = (DefaultOAuth2AccessToken) body;
		
		//Converte o serveHttpRequest/Response para HttpServletRequest/Response
		HttpServletRequest httpServletRequest = ((ServletServerHttpRequest) request).getServletRequest();
		HttpServletResponse httpServletResponse = ((ServletServerHttpResponse) response).getServletResponse();
		// recebe o refresh_token
		String refreshToken = body.getRefreshToken().getValue();
		adicionaRefreshTokenNoCookie(refreshToken, httpServletRequest, httpServletResponse);
		removerRefreshTokenDoBody(tokenBody);
		
		return body;
	}

	private void removerRefreshTokenDoBody(DefaultOAuth2AccessToken tokenBody) {
		tokenBody.setRefreshToken(null);
	}

	private void adicionaRefreshTokenNoCookie(String refreshToken, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
		refreshTokenCookie.setHttpOnly(true);
		refreshTokenCookie.setSecure(algamoneyFasApiProperty.getSeguranca().isEnableHttps());
		refreshTokenCookie.setPath(httpServletRequest.getContextPath() + "/oauth/token");
		refreshTokenCookie.setMaxAge(2592000);
		httpServletResponse.addCookie(refreshTokenCookie);
	}

}
