<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- TODO 024 HelloServlet_3에서 요청한 JSP 페이지/ 전달받은 자바 객체를 구성하여 HTML로 만들어 짐! -->
<html>
<head>
<meta charset="UTF-8">
<title>Servlet 3.x GET 이동 JSP</title>
</head>
<!-- 자바 객체 받아주기  -->
<%
	Object obj=request.getAttribute("returnValue");
	String str=(String)obj;
%>
<body>
<h3>서버로부터 전달받은 자바 객체: <%=str %></h3>

</body>
</html>