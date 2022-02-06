package com.drtrue.global.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 공통 ExcertionHandler 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExcertionHandler {

    /**
     * CustomException ExceptionHandler 정의
     * 
     * @param request, customException
     * @return ResponseEntity
     * @since 1.0
     */
    @ExceptionHandler({ CustomException.class })
    public ResponseEntity<ExceptionEntity> exceptionHandler(HttpServletRequest request, CustomException e) {
        log.info("=========================ExceptionHandler=========================");
        log.error("request URI : " + request.getRequestURI());
        log.error("CustomException: " + e.getError().getCode());
        log.info("=========================ExceptionHandler=========================");
        return ResponseEntity
                .status(e.getError().getStatus())
                .body(ExceptionEntity.builder()
                        .errorCode(e.getError().getCode())
                        .build());
    }

    /**
     * BadCredentialsException ExceptionHandler 정의
     * 
     * @param request, BadCredentialsException
     * @return ResponseEntity
     * @since 1.0
     */
    @ExceptionHandler({ BadCredentialsException.class })
    public ResponseEntity<ExceptionEntity> test(HttpServletRequest request, BadCredentialsException e) {
        log.info("=========================BadCredentialsException=========================");
        log.error("request URI : " + request.getRequestURI());
        log.error("Exception: " + e.getMessage());
        log.info("=========================BadCredentialsException=========================");
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ExceptionEntity.builder()
                        .errorCode(e.getMessage())
                        .build());
    }

    /**
     * Exception ExceptionHandler 정의
     * 
     * @param request, Exception
     * @return ResponseEntity
     * @since 1.0
     */
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<ExceptionEntity> test(HttpServletRequest request, Exception e) {
        log.info("=========================Exception=========================");
        log.error("request URI : " + request.getRequestURI());
        log.error("Exception: " + e.getMessage());
        log.info("=========================Exception=========================");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ExceptionEntity.builder()
                        .errorCode(e.getMessage())
                        .build());
    }
}
