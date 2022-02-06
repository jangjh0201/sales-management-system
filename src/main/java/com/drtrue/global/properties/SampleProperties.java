package com.drtrue.global.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * sample properties 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@Data
@Component
@ConfigurationProperties("sample")
public class SampleProperties {
    private String colorName;
}
