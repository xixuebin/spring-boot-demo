package com.yeahmobi.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yeahmobi.model.security.SysUser;


public interface UserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
