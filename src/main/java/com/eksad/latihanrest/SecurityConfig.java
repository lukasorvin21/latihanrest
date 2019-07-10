package com.eksad.latihanrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eksad.latihanrest.service.UsersService;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsersService usersService;
	
	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http.httpBasic().and() // membaca header basic auth
 		.csrf().disable()
 		.authorizeRequests()  //akses masuk ke url
 		.antMatchers("/admin/**").hasAuthority("ADMIN") // url yang mau diakses,hak akses khusus admin
 		.antMatchers("/user/**").hasAnyAuthority("ADMIN", "USER")
 		.and().formLogin().permitAll();
	}

 	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		/*
 		String admin = "admin";
 		String adminPassword = encoder().encode("1234");
 		
 		String user = "user";
 		String userPassword = encoder().encode("qwerty");
 		
 		auth.inMemoryAuthentication()
 			.withUser(admin).password(adminPassword).roles("ADMIN", "USER");
 		auth.inMemoryAuthentication()
			.withUser(user).password(userPassword).roles("USER");
			*/
 		
 		auth.userDetailsService(usersService).passwordEncoder(encoder());
 		}
 	
 	@Bean
	public BCryptPasswordEncoder encoder() {
 		System.out.println(new BCryptPasswordEncoder().encode("1234"));
		return new BCryptPasswordEncoder();

 	}

}
