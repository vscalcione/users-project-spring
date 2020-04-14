package it.intersistemi.corso.users.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//				.antMatchers("/css/**").permitAll()
				.anyRequest().fullyAuthenticated()
				.and().formLogin().permitAll()
//					.loginPage("/login")
//					.failureUrl("/login?error").permitAll()
//				.and()
//					.logout().permitAll()
					;
	}

}
