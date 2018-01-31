package com.swim4.swim.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 사용자 로그인 확인 인터셉터 HandlerInterceptorAdapter를 상속받아서 정의
 * */

public class LoginInterceptor extends HandlerInterceptorAdapter{

	//컨트롤러의 메서드 실행 전에 처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//세션정보 읽기
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("id");
		
		//로그인 되지 않은 경우 로그인 페이지로 이동
		if(loginId == null){
			String path = request.getContextPath();	//루트 경로
			response.sendRedirect(path+"/customer/loginForm");
			return false;
		}
		
		
		return super.preHandle(request, response, handler);	//이거 그냥 return true임
	}

	
}
