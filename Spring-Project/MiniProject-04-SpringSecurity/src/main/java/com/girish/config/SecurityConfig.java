package com.girish.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.girish.service.IUserManagementService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private IUserManagementService service;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
		        auth.userDetailsService(service)
		            .passwordEncoder(new BCryptPasswordEncoder());
		    }
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	            .antMatchers("/user/register","/user/login","/").permitAll() // ✅ No authentication or authorization for home
	            .antMatchers("/user/register").permitAll()
	            .antMatchers("/bank/offer").authenticated() // ✅ Only logged-in users
	            .antMatchers("/bank/balance").hasAnyAuthority("USER") // ✅ ROLE_USER required
	            .antMatchers("/bank/loan").hasAnyAuthority("USER","MANAGER") // ✅ ROLE_ADMIN required
	            .anyRequest().authenticated() // ✅ All other endpoints require authentication
	        .and()
	            .formLogin().defaultSuccessUrl("/")
	            .loginPage("/user/login")
	            .loginProcessingUrl("/login")
	            .failureUrl("/user/login?error")
	        .and()
	            .rememberMe() // ✅ Enables remember-me functionality
	        .and()
	            .logout() // ✅ Default logout URL: /logout
	            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	            .logoutSuccessUrl("/user/login?logout")
	        .and()
	            .exceptionHandling()
	                .accessDeniedPage("/bank/denied") // ✅ Custom access-denied page
	        .and()
	            .sessionManagement()
	                .maximumSessions(3)
	                .maxSessionsPreventsLogin(true); // ✅ Block second login
	}


}