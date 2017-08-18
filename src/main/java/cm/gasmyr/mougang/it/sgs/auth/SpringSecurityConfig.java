package cm.gasmyr.mougang.it.sgs.auth;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests().antMatchers("/about").permitAll().anyRequest().authenticated()
//				.and().formLogin().loginPage("/").permitAll().and().logout().permitAll().and()
//				.exceptionHandling();
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER").and().withUser("admin")
//				.password("admin").roles("ADMIN");
//	}

}
