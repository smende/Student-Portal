package com.msd.portal.security;

import javax.sql.DataSource;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
			http.authorizeRequests()
				.requestMatchers(EndpointRequest.toAnyEndpoint()).authenticated()
				.and().authorizeRequests()
				.anyRequest().authenticated()
				.and().formLogin()
				.and().httpBasic()
				.and().csrf().disable();
	}
	
	
	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	
	/**
	 * TODO
	 * 
	 * Update passwordEncoder with BCrypt_encoder
	 * 	
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}


}
