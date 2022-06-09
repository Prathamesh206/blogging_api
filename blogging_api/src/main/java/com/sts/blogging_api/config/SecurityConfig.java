package com.sts.blogging_api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sts.blogging_api.security.CustomUserServiceDetails;


@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	public static final String[] page_url= {"/v3/api-docs","/swagger-resources/**","/swagger-ui/**","webjars/**"
			};
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(this.customerDetails.loadUserByUsername(null)).passwordEncoder(null);
//	}
 
//	@Autowired
//	CustomUserServiceDetails customerDetails;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().antMatchers(page_url).permitAll().anyRequest().authenticated().and().httpBasic();
	}
	
	
	
	

}
