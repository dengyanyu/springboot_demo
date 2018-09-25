<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="common/h.jsp" %>


      <table class="table table-striped">
      
        <thead>
	        <tr>
	            <td>班级编号</td>
	            <td>班级名称</td>
	            <td>班级日期</td>
	            <td>班级人数</td>
	            <td>讲师姓名</td>
	            <td>班级教室名称</td>
	            <td>操作</td>
	         </tr>
 		</thead>
        <tbody>
	         <c:forEach items="${list}" var="a">
	         
	           <tr>
	            <td>${a.bid}</td>
	            <td>${a.bname }</td>
	            <td>${a.bdate}</td>
	            <td>${a.sid}</td>
	            <td>${a.jname }</td>
	            <td>${a.cname }</td>
	            <td>
	            <input class="btn btn-danger btn-xs" type="button" value="删除" onclick="del(${a.bid})">
	            <input class="btn btn-info btn-xs" type="button" value="分配讲师" onclick="fp(${a.bid})">
	            <input class="btn btn-info btn-xs" type="button" value="分配教室" onclick="jiaoshi()">
	            <input class="btn btn-info btn-xs" type="button" value="选择学生" onclick="xueze()">
	            </td>
	         </tr>
	         </c:forEach>
        </tbody>
      </table>
      
      
	      
	 <script type="text/javascript">
	   function del(bid){
		   if(confirm("确定要删除吗")){
			  location.href="del?bid="+bid;   
		   }
	   }
	   
	   function fp(bid){
		   location.href="selectTeacher?bid="+bid;
	   }
	 </script>
 
 
 
<%@include file ="common/t.jsp"%>