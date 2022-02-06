package com.drtrue.global.exception;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

/**
 * ExceptionHandlerFilter 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@Slf4j
@Component
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    /**
     * Filter 예외 handlr 정의
     * 
     * @author 이충욱
     * @since 1.0
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            // token 만료
            log.info("=========================ExpiredJwtException=========================");
            log.error("request URI : " + request.getRequestURI());
            log.error("ExpiredJwtException: " + e.getMessage());
            log.info("=========================ExpiredJwtException=========================");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        } catch (CustomException e) {
            // token 만료
            log.info("=========================CustomException=========================");
            log.error("request URI : " + request.getRequestURI());
            log.error("CustomException: " + e.getMessage());
            log.info("=========================CustomException=========================");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        } catch (Exception e) {
            // 예외
            log.info("=========================Exception=========================");
            log.error("request URI : " + request.getRequestURI());
            log.error("Exception: " + e.getMessage());
            log.info("=========================Exception=========================");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
