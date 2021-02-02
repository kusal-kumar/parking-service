package com.parking.service.parkingservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * The Class WebSecurityConfiguration.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * Configure.
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception 
    {
        http
         .csrf().disable()
         .authorizeRequests().anyRequest().authenticated()
         .and()
         .httpBasic();
    }
  
    /**
     * Configure global.
     *
     * @param auth the auth
     * @throws Exception the exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
            throws Exception 
    {
        auth.inMemoryAuthentication()
            .withUser("user")
            .password("{noop}password")
            .roles("USER");
    }
}
