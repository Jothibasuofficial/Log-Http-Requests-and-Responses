package com.jothibasu.learning.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jothibasu.learning.handler.RequestsAndResponsesHandler;

@Component
public class UsersInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private RequestsAndResponsesHandler requestsAndResponsesHandler;

	@Override
	public boolean preHandle(HttpServletRequest requestServlet, HttpServletResponse responseServlet, Object handler)
			throws Exception {
		System.out.println("INTERCEPTOR PREHANDLE CALLED");

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("INTERCEPTOR POSTHANDLE CALLED");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		System.out.println("INTERCEPTOR AFTERCOMPLETION CALLED");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		//RequestsAndResponsesHandler requestsAndResponsesHandler = new RequestsAndResponsesHandler();

		requestsAndResponsesHandler.storeRequestsAndResponses(httpRequest, httpResponse);

	}

}
