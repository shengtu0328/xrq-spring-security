package com.xrq.springsecurity;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfiguration {

      //如果配置了 此AuthenticationProvider 会替代DaoAuthenticationProvider
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
