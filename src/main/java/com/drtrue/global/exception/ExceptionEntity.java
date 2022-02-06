package com.drtrue.global.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

/**
 * ExceptionEntity 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@Data
@Builder
public class ExceptionEntity {

    private HttpStatus status;
    private String errorCode;
    
}
