package com.xrq.springsecurity.config;

import com.xrq.springsecurity.domain.AdminUserDetails;
import com.xrq.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class XrqSecurityConfig {


    @Autowired
    private UserService adminService;

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> {
            //TODO
            AdminUserDetails admin = null;
            if (admin != null) {
                return admin;
            }
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }

}
