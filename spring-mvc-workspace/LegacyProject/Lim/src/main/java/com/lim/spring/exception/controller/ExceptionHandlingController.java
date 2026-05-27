package com.lim.spring.exception.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.lim.spring.exception.InvalidPageException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlingController {
	
	private ModelAndView createErrorResponse(RuntimeException e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", e.getMessage()).setViewName("include/error_page");
		return mv;
	}
	
	@ExceptionHandler(InvalidPageException.class)
	protected ModelAndView authorizationException(InvalidPageException e) {
		return createErrorResponse(e);
	}
}
