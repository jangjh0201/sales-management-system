package com.drtrue.global.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

/**
 * XSS 대응 필터
 * 
 * @author 이충욱
 * @since 1.0
 */
@Component
public class XSSFilter implements Filter {

    /**
     * XSS 대응 필터
     * 
     * @param request, response, chain
     * @return void
     * @since 1.0
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = new XSSRequestWrapper((HttpServletRequest) request);
        chain.doFilter(req, response);
    }
}
