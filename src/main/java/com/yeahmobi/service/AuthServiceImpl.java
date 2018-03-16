package com.yeahmobi.service;


import com.yeahmobi.model.security.Authority;
import com.yeahmobi.model.security.AuthorityName;
import com.yeahmobi.security.JwtTokenUtil;
import com.yeahmobi.security.repository.UserRepository;
import java.util.Collections;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import com.yeahmobi.model.security.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public SysUser register(SysUser user) {
        final String username = user.getUsername();
        if(userRepository.findByUsername(username) != null) {
            return userRepository.findByUsername(username);
        }
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setEnabled(true);
        user.setEmail("xixuebin@163.com");
        user.setFirstname("xixi");
        user.setLastname("xuebin");
        user.setLastPasswordResetDate(new Date());
        Authority authority = new Authority();
        authority.setName(AuthorityName.ROLE_USER);
        user.setAuthorities(Collections.singletonList(authority));
        return userRepository.save(user);
    }

    @Override
    public String login(String username, String password) {
//        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
//        final Authentication authentication = authenticationManager.authenticate(upToken);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        final String token = jwtTokenUtil.generateToken(userDetails);
//        return token;
        return null;
    }

    @Override
    public String refresh(String oldToken) {
//        final String token = oldToken.substring(tokenHead.length());
//        String username = jwtTokenUtil.getUsernameFromToken(token);
//        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
//        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
//            return jwtTokenUtil.refreshToken(token);
//        }
        return null;
    }
}