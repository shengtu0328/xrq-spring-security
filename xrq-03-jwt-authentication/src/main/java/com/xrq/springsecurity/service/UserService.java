package com.xrq.springsecurity.service;

import com.xrq.springsecurity.domain.AdminUserDetails;

public interface UserService {

    public AdminUserDetails getAdminByUsername(String username);

    public String login(String username, String password);
    }
