package com.yeahmobi.service;


import com.yeahmobi.model.security.SysUser;

public interface AuthService {
    SysUser register(SysUser userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
