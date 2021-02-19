package com.koreait.mango.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor // final이 붙은 변수들에게 Autowired를 자동으로 붙여준다 
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	final private UserDetailsService memberService;
	
	// 암호화 
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// 시큐리티가 /res/** 의 파일들을 무시한다 
		web.ignoring().antMatchers("/res/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		공격을 막는다 
		http.csrf().disable();
		
//		권한 부여
		http.authorizeRequests()
			  .antMatchers("/user/**").hasRole("USER")
			  .antMatchers("/admin/**").hasRole("ADMIN")
			  .antMatchers("/**").permitAll(); // => 전부 접근권한 부여(가장 상단에 위치할 경우
//																	  권한 제한이 모두 풀려 접근이 가능해진다) 
		
//		로그인
		http.formLogin()
			  .loginPage("/login")
			  .defaultSuccessUrl("/home");
//			  .permitAll();
		
//		로그아웃
		http.logout()
			  .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			  .logoutSuccessUrl("/login")
			  .invalidateHttpSession(true);
		
//		에러발생시 설정한 주소로 이동
		http.exceptionHandling()
			  .accessDeniedPage("/denied");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		로그인 시 passwordEncoder() 를 실행해서 자동으로 암호화를 한다
		auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
	}
}
