package com.algamoneyFAS.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("angular")
				.secret("@ngul@r0")
				.scopes("read","write") // Define cliente que pode ter acesso somente a leitura, pode define scpes para diversos clientes
				.authorizedGrantTypes("password", "refresh_token") // Autoriza o uses e senha para o cliente, no caso o angula e dar um novo token
				.accessTokenValiditySeconds(1800) // duração do token
				.refreshTokenValiditySeconds(3600 * 24)//tempo de vida do refresh token - 1 dia.
			.and()
				.withClient("mobile")
				.secret("mobile")
				.scopes("read") 
				.authorizedGrantTypes("password", "refresh_token") 
				.accessTokenValiditySeconds(1800)
				.refreshTokenValiditySeconds(3600 * 24);
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.tokenStore(tokenStore())
			.accessTokenConverter(accessTokenConverter())
			// permite enviar um novo refresh token, assim que pedir um acces tokens,
			//enquanto se o usuário estiver usando a aplicação nunca irá deslogar sozinha
			.reuseRefreshTokens(false) 
			.authenticationManager(authenticationManager);
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey("chave");
		return accessTokenConverter;
	}
	// Armazena os tokens
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
}
