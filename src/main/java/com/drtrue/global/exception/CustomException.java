package com.drtrue.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * CustomException 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{

    private ExceptionEnum error;

}
