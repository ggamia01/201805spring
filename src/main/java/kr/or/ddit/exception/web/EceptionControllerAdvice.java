package kr.or.ddit.exception.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EceptionControllerAdvice {

	@ExceptionHandler({ArithmeticException.class})
	public String exceptionHandler() {
		return "error/arithmetic";
	}
}
