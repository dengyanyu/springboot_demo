<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="common/h.jsp" %>

	 <form id="sf" action="/page" method="post">
	 	<input name="pageNum" value="${page.pageNum}"><br>
	 	<input name="pageSize" value="${page.pageSize}"><br>
	 	<input name="tname" placeholder="讲师名" value="${tname}"><br>
	 	<input name="rname" placeholder="教室名" value="${rname}"><br>
	 	<input name="minCount" placeholder="最少人数" value="${minCount}"><br>
	 	<input name="maxCount" placeholder="最多人数" value="${maxCount}"><br>
	 	<input type="submit">
	 
	 </form>
      <table class="table table-striped text-center">
      
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
	         <c:forEach items="${page.list}" var="a">
	         
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
      <script>
      	//钩子函数
      	function topage(pn,ps){
      		$("[name='pageNum']").val(pn);
      		$("[name='pageSize']").val(ps||"${page.pageSize}");
      		$("#sf").submit();
      		//location.href="page?pageNum="+pn+"&pageSize="+(ps||"${page.pageSize}");
      	}
      </script>
      
      <%@include file ="common/pager.jsp"%>
      
	      
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