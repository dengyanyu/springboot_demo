 	<div class="text-center">
      	<ul class="pagination">
		    <li><a href="javascript:topage(1);">&laquo;</a></li>
		    
		    
		    
		    <c:if test="${page.pageNum-3>0}">
		   		 <li><a href="javascript:topage(${page.pageNum-3});">${page.pageNum-3}</a></li>
		    </c:if>
		    <c:if test="${page.pageNum-2>0}">
		   		 <li><a href="javascript:topage(${page.pageNum-2});">${page.pageNum-2}</a></li>
		    </c:if>
		    <c:if test="${page.pageNum-1>0}">
		   		 <li><a href="javascript:topage(${page.pageNum-1});">${page.pageNum-1}</a></li>
		    </c:if>
		    
		    <li class="active"><a href="#">${page.pageNum}</a></li>
		    
		    <c:if test="${page.pageNum+1<=page.pages}">
		    	<li><a href="javascript:topage(${page.pageNum+1});">${page.pageNum+1}</a></li>
		    </c:if>
		     <c:if test="${page.pageNum+2<=page.pages}">
		    	<li><a href="javascript:topage(${page.pageNum+2});">${page.pageNum+2}</a></li>
		    </c:if>
		    <c:if test="${page.pageNum+3<=page.pages}">
		    	<li><a href="javascript:topage(${page.pageNum+3});">${page.pageNum+3}</a></li>
		    </c:if>
		    
		    
		    
		    <li><a href="javascript:topage(${page.pages});">&raquo;</a></li>
		</ul>
      </div>