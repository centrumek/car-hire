package pl.edu.agh.carhire.config;

import pl.edu.agh.carhire.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}

	/* if we want to use inMemoryAuthentication
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.withUser("ranko").password("ranko").roles("USER");
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/resources/**", "/login", "/", "/logout").permitAll()
				.antMatchers("/admin", "/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login")
				.and()
				.logout().logoutSuccessUrl("/login?logout")
				.and()
				.exceptionHandling().accessDeniedPage("/403")
				.and()
				.csrf();  //Preventing cross-site request forgery (CSRF)
	}

	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}