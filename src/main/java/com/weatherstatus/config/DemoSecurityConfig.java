package com.weatherstatus.config;


import javax.sql.DataSource;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger logger = LogManager.getLogger(DemoSecurityConfig.class.getName());	
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * UserBuilder users = User.withDefaultPasswordEncoder();
		 * 
		 * auth.inMemoryAuthentication()
		 * .withUser(users.username("user").password("123").roles("USER"))
		 * .withUser(users.username("admin").password("123").roles("USER", "ADMIN"));
		 */
		// use jdbc authentication !!!
		try {
			logger.info("inside configure to autonticate users from database");
			auth.jdbcAuthentication().dataSource(securityDataSource).passwordEncoder(new BCryptPasswordEncoder());
		} catch (Exception e) {
			logger.error(e.getMessage());

		}

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("inside configure HttpSecurity give premission for all users to log and register and logout pages");
		http.authorizeRequests().antMatchers("/", "/welcome", "/login", "/logout", "/register").permitAll();
		logger.info("inside configure HttpSecurity give premission for all users to log and register and logout pages");
		http.authorizeRequests().antMatchers("/").hasRole("USER").antMatchers("/admin/**").hasRole("ADMIN").and()
				.formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll().and()
				.logout().permitAll().and().exceptionHandling().accessDeniedPage("/access-denied").and().csrf()
				.disable();
	}

}
