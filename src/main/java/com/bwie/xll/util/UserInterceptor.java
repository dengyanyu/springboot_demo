package com.bwie.xll.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class UserInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String sid = UserUtil.getUser(request);
		System.out.println("进入拦截器----------------------------------"+sid);
		
		if (sid==null) {
			response.sendRedirect("/loginPage");
			return false;
		}
		return true;
	}
}
