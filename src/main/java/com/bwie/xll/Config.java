package com.bwie.xll;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bwie.xll.util.UserInterceptor;
@Configuration
public class Config extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("注册拦截器----------------------------------");
		registry.addInterceptor(new UserInterceptor()).addPathPatterns("/*").excludePathPatterns("/loginPage","/login");
	}
}
