<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap3/css/bootstrap.css" type="text/css"></link>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>
</head>
<body class="container">

	

      <table  class="table table-striped">
      	<thead>
	         <tr>
	            <td>讲师id</td>
	            <td>讲师名称 </td>
	            <td>入职日期</td>
	            <td>操作</td>
	         </tr>
	     </thead>
	     <tbody>
	         <c:forEach items="${list}" var="a">
	           <tr ${tid == a.jid?" class='success' ":" "} >
	            <td>${a.jid}</td>
	            <td>${a.jname }</td>
	            <td>${a.jdate }</td>
	            <td>
	            	<input  class="btn btn-info btn-xs" type="button" value="分配" onclick="fen(${a.jid})">
	            </td>
	         </tr>
	         </c:forEach>
         </tbody>
      </table>
      
      
<script type="text/javascript">
  function fen(jid){
	 $.post("fen",{jid:jid},function(obj){
		 console.log("分配讲师返回结果",obj);
		 if(obj){
			 location.href="list";
		 }else{
			 alert("讲师已存在");
		 }
		
	 },"json")
  }
</script>


</body>
</html>