<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="common/h.jsp" %>


     

	<form action="/select"  method="post">
		<select id="s1" name="s1id" onchange="s2x(this.value)" 
		
		val="${s1id}"
		op_url="/s1"  
		op_key="id" 
		op_val="jbname"  
		
		>
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
//封装组件


	function s1x(select1){
		var op_url=$(select1).attr("op_url");
		var op_key=$(select1).attr("op_key");
		var op_val=$(select1).attr("op_val");
		var s1id=$(select1).attr("val");//s1
		
		
		$.get(op_url,function(data){
			
			for(var i in data)	{
				var o =data[i];
				$(select1).append("<option value='"+o[op_key]+"' "+(s1id==o[op_key]?" selected='true' ":"")+">"+o[op_val]+"</option>");
				if(s1id==o.id){//触发后面的联动进行回显
					s2x(s1id);
				}
			}
		});
	}
	s1x("#s1");//初始化
	
	function s2x(s1id,select1){
		
		
		var op_url=$(select1).attr("op_url");
		var op_key=$(select1).attr("op_key");
		var op_val=$(select1).attr("op_val");
		var s1id=$(select1).attr("val");//s1
		
		$(select1).empty();
		$(select1).append("<option value='0'>--全部--</option>");
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