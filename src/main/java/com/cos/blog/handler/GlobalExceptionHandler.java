package com.cos.blog.handler;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public String handleArgumentExceptio(IllegalArgumentException e) {
		return "<h1>" + e.getMessage() +"</h1>";
	}

}
