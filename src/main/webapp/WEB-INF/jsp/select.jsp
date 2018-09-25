<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="common/h.jsp" %>


     

	<form action="/select"  method="post">
		<select id="s1" name="s1id" onchange="s2x(this.value)" op_val="${s1id}">
			<option value="0">--全部--</option>
		</select> 
		<select id="s2"  name="s2id"   op_val="${s2id}"></select> 
		
		<input name="sname" value="${sname}"> <input type="submit">
	</form>
	
	
	
	<div>
		 <table class="table table-striped">
      
        <thead>
	        <tr>
	            <td>编号</td>
	            <td>姓名</td>
	            <td>住址</td>
	         </tr>
 		</thead>
        <tbody>
	         <c:forEach items="${list}" var="s">
	         
	           <tr>
	            <td>${s.sid}</td>
	            <td>${s.sname }</td>
	            <td>${s.zhuzhi }</td>
	         </tr>
	         </c:forEach>
        </tbody>
      </table>
      
	
	</div>
<script type="text/javascript">
	$.get("/s1",function(data){
		var s1id=$("#s1").attr("op_val");//s1
		for(var i in data)	{
			var o =data[i];
			$("#s1").append("<option value='"+o.id+"' "+(s1id==o.id?" selected='true' ":"")+">"+o.jbname+"</option>");
			if(s1id==o.id){//触发后面的联动进行回显
				s2x(s1id);
			}
		}
	});
	
	function s2x(s1id){
		$("#s2").empty();
		$("#s2").append("<option value='0'>--全部--</option>");
		if(s1id){
			$.get("/s2?s1id="+s1id,function(data){
				var s2id=$("#s2").attr("op_val");//s1
				$("#s2").removeAttr("op_val");//防止后续干扰
				for(var i in data)	{
					var o =data[i];
					$("#s2").append("<option value='"+o.bid+"' "+(s2id==o.bid?" selected='true' ":"")+">"+o.bname+"</option>");
				}
			})
		}
	}
</script>



<%@include file ="common/t.jsp"%>