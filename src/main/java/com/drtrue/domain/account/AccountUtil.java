package com.drtrue.domain.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class AccountUtil {

    @Autowired
    AuthenticationManager authenticationManager;

    /**
     * 계정 인증
     * 
     * @return void
     * @since 1.0
     */
    public void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
