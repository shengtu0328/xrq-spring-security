package com.xrq.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Configuration
public class AuthConfiguration {

      //此AuthenticationProvider 会替代DaoAuthenticationProvider
//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//
//        return new AuthenticationProvider() {
//            @Override
//            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//                String name = authentication.getName();
//                Object principal = authentication.getPrincipal();
//                return new UsernamePasswordAuthenticationToken(name, principal);
//            }
//
//            @Override
//            public boolean supports(Class<?> authentication) {
//                return authentication.equals(UsernamePasswordAuthenticationToken.class);
//            }
//        };
//    }

}
