<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="common/h.jsp" %>

<c:if test="${stu.sid!=null}">
	<a href="/page">你已经通过免密登陆,点击这里进入首页</a>
</c:if>
	 <form   action="/login" method="post">
	 	<input name="rem" value="true"><br>
	 	<input name="name" value="${name}"><br>
	 	<input name="pwd" placeholder="密码" value="${pwd}"><br>
	 	<input type="submit">
	 
	 </form>
      
 
 
<%@include file ="common/t.jsp"%>