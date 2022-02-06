package com.drtrue.global.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ExceptionEnum 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@Getter
@AllArgsConstructor
public enum ExceptionEnum {
    
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request"),
	UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Unauthorized"),
	PAYMENT_REQUIRED(HttpStatus.PAYMENT_REQUIRED, "Payment Required"),
	FORBIDDEN(HttpStatus.FORBIDDEN, "Forbidden"),
	NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found"),
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "Method Not Allowed"),
	NOT_ACCEPTABLE(HttpStatus.NOT_ACCEPTABLE, "Not Acceptable"),
	PROXY_AUTHENTICATION_REQUIRED(HttpStatus.PROXY_AUTHENTICATION_REQUIRED, "Proxy Authentication Required"),
	REQUEST_TIMEOUT(HttpStatus.REQUEST_TIMEOUT, "Request Timeout"),
	CONFLICT(HttpStatus.CONFLICT, "Conflict"),
	GONE(HttpStatus.GONE, "Gone"),
	LENGTH_REQUIRED(HttpStatus.LENGTH_REQUIRED, "Length Required"),
	PRECONDITION_FAILED(HttpStatus.PRECONDITION_FAILED, "Precondition Failed"),
	PAYLOAD_TOO_LARGE(HttpStatus.PAYLOAD_TOO_LARGE, "Payload Too Large"),
	URI_TOO_LONG(HttpStatus.URI_TOO_LONG, "URI Too Long"),
	UNSUPPORTED_MEDIA_TYPE(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type"),
	REQUESTED_RANGE_NOT_SATISFIABLE(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE, "Requested range not satisfiable"),
	EXPECTATION_FAILED(HttpStatus.EXPECTATION_FAILED, "Expectation Failed"),
	I_AM_A_TEAPOT(HttpStatus.I_AM_A_TEAPOT, "I'm a teapot"),
	UNPROCESSABLE_ENTITY(HttpStatus.UNPROCESSABLE_ENTITY, "Unprocessable Entity"),
	LOCKED(HttpStatus.LOCKED, "Locked"),
	FAILED_DEPENDENCY(HttpStatus.FAILED_DEPENDENCY, "Failed Dependency"),
	TOO_EARLY(HttpStatus.TOO_EARLY, "Too Early"),
	UPGRADE_REQUIRED(HttpStatus.UPGRADE_REQUIRED, "Upgrade Required"),
	PRECONDITION_REQUIRED(HttpStatus.PRECONDITION_REQUIRED, "Precondition Required"),
	TOO_MANY_REQUESTS(HttpStatus.TOO_MANY_REQUESTS, "Too Many Requests"),
	REQUEST_HEADER_FIELDS_TOO_LARGE(HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE, "Request Header Fields Too Large"),
	UNAVAILABLE_FOR_LEGAL_REASONS(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "Unavailable For Legal Reasons"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");

    private final HttpStatus status;
    private final String code;
}
