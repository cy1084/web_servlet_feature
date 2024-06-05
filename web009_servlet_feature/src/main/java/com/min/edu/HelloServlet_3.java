package com.min.edu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * TODO 018 Servlet 3.x 방식으로 선언 (Annotation 방식)
 */
@WebServlet(urlPatterns = {"/servlet3.do"}, initParams= {@WebInitParam (name="name",value="initParam")})

/*이렇게 작성하는 경우는 잘 없음*/

public class HelloServlet_3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//TODO 019 HelloServlet_3의 GET 요청
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet 3.0 방식의 GET 요청");
		
		//TODO 020 init-param 호출은 해당 클래스에서만 가능하다	<<Servlet Config>>
		String otherInitParam=getServletConfig().getInitParameter("webInit");
		System.out.println("다른 Servlet Class의 initParam 값: "+otherInitParam);
		
		//TODO 021 @ Annotation 방법을 통한 initParam
		String initParam=getServletConfig().getInitParameter("name");
		System.out.println("Annotation 방법으로 선언한 initParam"+initParam);
		
		//흐름 제어
		// TODO 022 
		// 1) response.sendRedirect("이동화면")
		//	-> 주소에 요청되는 값: queryString으로 값 전달 가능/ 객체의 값은 전달 불가
		//	ex) 화면에 값 전달
		
//		resp.setContentType("application/json; charset=UTF-8;");
//		String json=String.format("{\"json\":\"%s\"}", initParam);
//		resp.getWriter().print(json);
		
		
		//TODO 023
		// 2) RequestDispatcher forward 객체 -> pass by reference로 전달받은 HttpServletRequest/HttpServletResponse 객체를 pass by reference로 전달
		//									-> 서버(WAS)에서 JSP와 전달(scope)받은 객체를 로직 처리하여 HTML을 만든다
		req.setAttribute("returnValue", initParam);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/views/servlet3.jsp"); 
		dispatcher.forward(req, resp);
		
}

}
