package com.algaworks.algamoney.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

/*
 * Retira o aviso de função depreciadas... Consultei no forum e já existia resposta... ao questionamento
 * de outro aluno.! Por isso vou suprimir avisos e seguir em frente.
 *
 * José Ademar de Oliveira Junior
 * 26/04/2021 às 16:58
 * Olá a todos!
 *  Nessa aula Implementando segurança com OAuth2 e Password Flow está muito
 * confusa. Não consegui compreender e nem implementar essa parte, também não consegui usar as anotações que foram usadas e o 
 * metodo do passwordEncoder está desatualizado
 * 
 * Resposta a questão no forum:
 * https://app.algaworks.com/forum/topicos/84246/6-3-implementando-seguranca-com-oauth-2-e-password-flow
 * Alexandre Moraes Tannus Tutor
 *  27/04/2021 às 13:49
 *  Boa tarde José,
 *   Você tentou utilizar as instruções contidas no material de apoio da aula? Nele tem instruções de como fazer na 
 *   versão 2.1.5, que é bastante similar nesse conteúdo à versão que você está utilizando.
 * 
 *   Em aulas posteriores a questão do password encoder será tratada, para retirar esse problema da depreciação. 
 *   Se possível, poste o código que apresentou erros/problemas e indique qual foi a dificuldade nele para que 
 *   possamos ajudar de forma mais direcionada.
 */
@SuppressWarnings("deprecation") 

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true) //habilita a segurança nos metodos
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
						.antMatchers("/categorias").permitAll()
						.anyRequest().authenticated()
						.and()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
					.csrf().disable();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.stateless(true);
	}

	@Bean
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Bean
	public MethodSecurityExpressionHandler createExpressionHandler() {
		return new OAuth2MethodSecurityExpressionHandler();
	}
}