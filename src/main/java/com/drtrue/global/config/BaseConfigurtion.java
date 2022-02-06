package com.drtrue.global.config;

import com.drtrue.global.properties.SampleProperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Base 설정 파일 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@Configuration
@EnableScheduling
@EnableJpaAuditing
@EnableConfigurationProperties({ SampleProperties.class })
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
}
