// CLASSE DE CONFIGURAÇÃO HTTP BASIC STATICO

//package com.algamoneyFAS.api.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//@Configuration
//@EnableWebSecurity
//public class ConfigSecurity extends WebSecurityConfigurerAdapter {
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("admin").password("admin").roles("ROLE");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//			http.authorizeRequests()
//				.antMatchers("/categorias").permitAll() // So categoria não precisa de autenticação
//				.anyRequest().authenticated()
//				.and()
//				.httpBasic().and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//				.csrf().disable();
//	}
//}
