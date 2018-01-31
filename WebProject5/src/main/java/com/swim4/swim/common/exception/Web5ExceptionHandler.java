package com.swim4.swim.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Web5ExceptionHandler {
	
	//404와 500을 제외한 에러를 처리해준다
	//404와 500도 처리하려면 web.xml에 설정해줘야한다
	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception e){
		e.printStackTrace();
		return "/error";
	}
}
