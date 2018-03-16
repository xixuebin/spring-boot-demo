package com.yeahmobi.security.service;

import com.yeahmobi.model.security.SysUser;
import java.io.Serializable;


public class JwtAuthenticationResponseUser implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;


    private final String username;
    private final String email;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private final String firstName;
    private final String lastName;

    public JwtAuthenticationResponseUser(SysUser sysUser) {

        this.username = sysUser.getUsername();
        this.email = sysUser.getEmail();
        this.firstName = sysUser.getFirstname();
        this.lastName = sysUser.getLastname();

    }

}
