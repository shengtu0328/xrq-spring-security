package com.xrq.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.UUID;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/home").permitAll()
				.antMatchers("/a").hasAuthority("admin")
				.anyRequest().authenticated()
			)
			//开启记住我功能
			.rememberMe((x)->x.key(UUID.randomUUID().toString()))
			//表单登录
			.formLogin((form) -> form
				.loginPage("/xrqLoginPage")//没登录时，redirect的地址
				.loginProcessingUrl("/xrqLoginProcessingUrl")//登陆逻辑处理url，也就是后端登录接口
				.usernameParameter("u")//表单登录用户名参数名称
				.passwordParameter("p")//表单登录密码参数名称
				.permitAll()
			)
			//注销
			.logout((logout) -> logout
				.logoutUrl("/xrqLogoutUrl")//注销url
				.invalidateHttpSession(true)//注销后的操作
				.clearAuthentication(true)//注销后的操作
				.logoutSuccessUrl("/xrqLoginPage")//注销后跳转的地址，一般就是登录页面
			)
			//禁用 跨站请求伪造
			.csrf().disable();

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("xrq")
				.password("123456")
				.authorities("admin")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
