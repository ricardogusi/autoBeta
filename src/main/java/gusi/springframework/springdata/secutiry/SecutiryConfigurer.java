package gusi.springframework.springdata.secutiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import gusi.springframework.springdata.repository.UserRepository;

@EnableWebSecurity
@Configuration
public class SecutiryConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	public AuthenticationService authenticationService;
	
	@Autowired
	public TokenService tokenService;
	
	@Autowired
	public UserRepository userRepository;

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {

		return super.authenticationManager();
	}

	// Configurações de autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
	}

	// Configurações de autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/auth").permitAll()				
				.antMatchers("/user/**").permitAll()	
				.antMatchers("/light/**").permitAll()
				.antMatchers("/restart").permitAll()
				.antMatchers("/actuator/**").permitAll()
				.antMatchers("/**").permitAll()
				.anyRequest().authenticated()
				.and().csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(new AuthenticationTokenFilter(tokenService, userRepository),
						UsernamePasswordAuthenticationFilter.class);

	}

	// Configurações de recursos estáticos (js.css,img etc)
	@Override
	public void configure(WebSecurity web) throws Exception {

	}
	
	
	

}
