package com.xrq.springsecurity.config;

import com.xrq.springsecurity.component.RestAuthenticationEntryPoint;
import com.xrq.springsecurity.component.RestfulAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //因为是JWT,JWT也是一种token，不需要session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeHttpRequests((requests) -> {
                    List<String> ignoreUrls = ignoreUrlsConfig.getUrls();
                    requests
                            .antMatchers(ignoreUrls.toArray(new String[ignoreUrls.size()])).permitAll()
                            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                            .anyRequest().authenticated();
                }
        );
        //添加自定义未授权和未登录结果返回 可以不配置？
//        http.exceptionHandling()
//                .accessDeniedHandler(restfulAccessDeniedHandler)
//                .authenticationEntryPoint(restAuthenticationEntryPoint);
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.csrf().disable();
        return http.build();
    }


}
