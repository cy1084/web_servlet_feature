package com.min.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO 010 Servlet 클래스는 HttpServlet을 extends 하여 화면의 요청을 처리할 수 있는 클래스가 된다
 * 			Servlet 2.x의 작성 방법은 명시적으로 web.xml에 클래스와 주소를 매핑하는 설정을 작성해야 한다
 */

public class HelloServlet_2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1113295075530085069L;
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet_2의 doGet 요청");
		
		//TODO 012 GET 요청에 따른 화면 흐름 제어 request를 통한 JSP 페이지 요청
		req.getRequestDispatcher("/WEB-INF/views/servlet2.jsp").forward(req,resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet_2의 doPost 요청");
		
		//요청된 하나의 초기값(init-param)을 사용한다. 다른 서블릿에서는 사용할 수 없다
		String initParam=getServletConfig().getInitParameter("webInit");
		System.out.println("초기에 입력받은 init param: "+initParam);
		
		//TODO 017 프로젝트(Context)에서 모두 사용 가능한 param: context param
		String contextParam=getServletContext().getInitParameter("contextParam");
		System.out.println("초기에 Application에 전체적으로 사용할 수 있는 초기값 context param: "+contextParam);
		
	}
}
