package com.metacube.metaparkingsystemv2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * This is used for creating own user id,password and user.
	 * In the AuthenticationManagerBuilder class override the default class to provide these features.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
			.withUser("root")
			.password("root")
			.roles("USER")
			.and()
			.withUser("foo")
			.password("foo")
			.roles("ADMIN");
	}
	
	/*
	 * It is used to avoid clear-text means it will not save the password.
	 * It will encode the password and pass it.
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	/*
	 * In this method HttpSecurity defines the path and access restriction to that path.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/**").hasAnyRole("USER", "ADMIN")
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll();
	}
	
	
}
