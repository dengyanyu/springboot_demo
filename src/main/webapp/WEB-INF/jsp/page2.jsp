<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="common/h.jsp" %>

	 <form id="sf" action="/page2" method="post" class="form-inline">
		 <div class="form-group" style="display:none">
	    	<label >当前页-页长</label>
		 	<input class="form-control"   name="pageNum" value="${page.pageNum}"> 
		 	<input class="form-control"  name="pageSize" value="${page.pageSize}"> 
		 </div>
		 <div class="form-group">
	    	<label>讲师名</label>
	 		<input class="form-control input-sm"  name="tname" placeholder="讲师名" value="${tname}"> 
	 	</div>
	 	<div class="form-group">
	    	<label>教室名</label>
	 		<input class="form-control input-sm"  name="rname" placeholder="教室名" value="${rname}"> 
	 	</div>
	 	<div class="form-group">
	    	<label>人数</label>
		 	<input class="form-control input-sm"  name="min" placeholder="最少人数" value="${min}"> 
		 	<input class="form-control input-sm"  name="max" placeholder="最多人数" value="${max}"> 
		 </div>
	 	<input class="form-control input-sm"  type="submit">
	 
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