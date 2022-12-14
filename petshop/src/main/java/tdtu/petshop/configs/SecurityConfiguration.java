package tdtu.petshop.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/login", "/register")
			.permitAll();
		http.authorizeRequests().antMatchers("/cart/**", "/addcart")
			.hasAnyAuthority("customer", "staff", "admin");
		http.authorizeRequests().antMatchers("/staff/**")
			.hasAnyAuthority("staff", "admin");
		http.authorizeRequests().antMatchers("/admin/**")
			.hasAuthority("admin");
		http.authorizeRequests().and().formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/");
		http.authorizeRequests().and().logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/");
		http.authorizeRequests().and().exceptionHandling()
			.accessDeniedPage("/accessDenied");
		http.authorizeRequests().and().httpBasic();
	}
	
}
