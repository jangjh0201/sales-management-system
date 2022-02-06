package com.drtrue.global.security;

import javax.servlet.http.HttpServletRequest;

import com.drtrue.global.jwt.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 동적 원한 체크 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@Component
@Slf4j
public class AuthorizationChecker {

    @Autowired
    JwtUtil jwtUtil;

    /**
     * 권한 체크 로직 정의
     * 
     * @param request, authentication
     * @return boolean
     * @author 이충욱
     * @since 1.0
     */
    public boolean check(HttpServletRequest request, Authentication authentication) {
        log.info("====================authorizationChecker=========================");
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer "))
            return false;
        
        String token = authorizationHeader.substring(7);
        if(!jwtUtil.validateToken(token, (UserDetails)authentication.getPrincipal()))
            return false;
        
        log.info("====================authorizationChecker=========================");
        return true;
    }

}
