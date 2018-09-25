<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
 <HEAD>
  <TITLE> ZTREE DEMO </TITLE>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="/js/ztree/css/demo.css" type="text/css">
  <link rel="stylesheet" href="/js/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
  <script type="text/javascript" src="/js/ztree/js/jquery-1.4.4.min.js"></script>
  <script type="text/javascript" src="/js/ztree/js/jquery.ztree.core.js"></script>
  <script>
   var zTreeObj;//定义在外边是因为有序如果有其他调用可以直接调用到对象
   var setting = {
		   
		   data: {
				key: {
					children: "clazzList",
					name: "bname"
				}

			}
		   
   };//配置
  
   
   $(function(){//初始化
	   
	 $.get("/ztreejson",function(zNodes){
		 
		   for(var i in zNodes){//format
			   zNodes[i].bname=zNodes[i].jbname;
			   zNodes[i].open=true;
			   zNodes[i].url="https://www.baidu.com/s?wd="+zNodes[i].bname;
			   zNodes[i].target="x";
		   }
	      zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
	 });
	   
	   
   });
  </script>
 </HEAD>
<BODY>
<div>
   <ul id="treeDemo" class="ztree" style="width:24%;float:left;"></ul>
   <div style="width:73%;float:left;border:1px solid blue;">
   	<iframe id="x" name="x"   scrolling="no" style="width: 100%;height: 2000px;"></iframe>
   </div>
</div>
</BODY>
</html>
    
    
    
    
    