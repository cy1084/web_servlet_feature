package com.min.edu.comm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/*
 * TODO 028 Filter 처리를 위한 javax.servlet.Filter 구현 클래스, Life-Cycle 구조(init, service, destroy)
 */
public class HelloFilter implements Filter {
	@Override
	public void destroy() {
		System.out.println("--------Hello Filter destroy------------");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("--------Hello Filter Initial------------");
	}
	
	
	//TODO 029 필터의 기능을 사용하여 흐름제어를 만들어본다
	//요청되는 주소에 queryString의 값이 flag=2 라면 기존 흐름대로/ 아닌 경우에는 에러 페이지로 이동
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp , FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request=(HttpServletRequest)req;
		String flag=request.getParameter("flag");
		if(flag.equals("2")) {
			//http://localhost:8080/web009_servlet_feature/servlet2.do?flag=2
			//정상흐름
			chain.doFilter(req, resp);
		}else {
			//http://localhost:8080/web009_servlet_feature/servlet2.do?flag=3
			//잘못된 페이지 요청 흐름
			request.getRequestDispatcher("/WEB-INF/views/error/error404.html").forward(req, resp);
			
		}
			

	}


}
