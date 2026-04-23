package com.rammohan.production_service.exceptionHandling;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public Mono<String> handle(Exception e) {
		return Mono.just("Error: " + e.getMessage());
	}
}