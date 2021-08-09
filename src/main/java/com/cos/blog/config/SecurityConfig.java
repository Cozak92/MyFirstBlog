package com.cos.blog.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.blog.auth.PrincipalDetailService;

@Configuration // 빈등록 (IoC관리)
@EnableWebSecurity // 스프링 시큐리티 필터 추가
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정주소로 접근시 권한 및 인증 미리체크
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PrincipalDetailService principalDetailService;
	
	
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	
	//무엇으로 패스워드 인코딩했는지 알아야 디코딩할때 확인 할 수있다.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable() // csrf 토큰 비활성화
			.authorizeRequests()
			.antMatchers("/","/auth/**","/js/**","/css/**","/image/**")
			.permitAll()
			.anyRequest()
			.authenticated()
		.and()
			.formLogin()
			.loginPage("/auth/loginForm")
			.loginProcessingUrl("/auth/loginProc")
			.defaultSuccessUrl("/");
		http.rememberMe()
			.key("uniqueAndSecret")
			.rememberMeParameter("remember-me");

	}
	
}
