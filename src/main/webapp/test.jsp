<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%pageContext.setAttribute("name", "wangwu"); %>
<%request.setAttribute("name", "zhangsan"); %>
<%session.setAttribute("name", "lisi"); %>
<body>
作用域 el
	<% int a=1; %>${name}
	 
</body>
</html>