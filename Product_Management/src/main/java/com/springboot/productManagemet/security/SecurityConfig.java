package com.springboot.productManagemet.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.springboot.productManagemet.service.MyUserUserDetailsService;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserUserDetailsService();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests((authorizeHttpRequests)->
		authorizeHttpRequests.requestMatchers(new AntPathRequestMatcher("/user/**")).authenticated()).formLogin((formLogin) ->
			formLogin
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl("/user/products", true)
		); 
		return http.build();
	}
	//@Bean
	//public PasswordEncoder passwordEncoder() {
		//return new NoOp();
	//}
	
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return authenticationProvider;
	}
	
}
