package com.drtrue;

import com.drtrue.global.properties.SampleProperties;
import com.drtrue.privacyspringbootstarter.PrivacyConfiguration;
import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring Boot 프로젝트 시작 클래스
 * 
 * @author 이충욱
 * @since 1.0
 */
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@EnableScheduling
@EntityScan(basePackageClasses = {SalesManagementSystemApplication.class, PrivacyConfiguration.class})
@EnableConfigurationProperties({ SampleProperties.class })
public class SalesManagementSystemApplication {

	/**
	 * Spring Boot main 메소드
	 * 
	 * @since 1.0
	 */
	public static void main(String[] args) {
		SpringApplication.run(SalesManagementSystemApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<XssEscapeServletFilter> filterRegistrationBean() {
		FilterRegistrationBean<XssEscapeServletFilter> filterRegistration = new FilterRegistrationBean<>();
		filterRegistration.setFilter(new XssEscapeServletFilter());
		filterRegistration.setOrder(1);
		filterRegistration.addUrlPatterns("/*");

		return filterRegistration;
	}

}
