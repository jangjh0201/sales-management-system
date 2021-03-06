package com.drtrue.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

/**
 * Base 설정 파일 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@Configuration
public class BaseConfigurtion implements WebMvcConfigurer {

    /**
     * PasswordEncoder Bean 정의
     * 
     * @return PasswordEncoder
     * @since 1.0
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * CORS 허용 URL 정의
     * 
     * @since 1.0
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:3000");
    }

    // thymeleaf layout
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
