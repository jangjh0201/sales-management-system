package com.drtrue.global.config;

import com.drtrue.global.exception.ExceptionHandlerFilter;
import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;

/**
 * Security 설정 파일 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private ExceptionHandlerFilter exceptionHandlerFilter;

    /**
     * Security 관련 설정
     * 
     * @param httpSecurity
     * @since 1.0
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .headers()
            .xssProtection()
            .and()
            .contentSecurityPolicy("script-src 'self'");

        httpSecurity
            .cors().and()
            .csrf().disable()
            .formLogin().and()
            .authorizeRequests()
            .antMatchers("/account/**").permitAll()
            .anyRequest().authenticated().and()
            .addFilterBefore(new XssEscapeServletFilter(), WebAsyncManagerIntegrationFilter.class)
            .addFilterBefore(exceptionHandlerFilter, UsernamePasswordAuthenticationFilter.class)
            .httpBasic();
    }

    /**
     * 로그인 관련 Manager Bean 정의
     * 
     * @return authenticationManagerBean
     * @since 1.0
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * resource 관련 파일 보안 예외
     * 
     * @param webSecurity
     * @since 1.0
     */
    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers("/resources/**");
    }
}
