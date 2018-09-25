<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="common/h.jsp" %>


     

    <form method="POST" enctype="multipart/form-data" action="/upload">
        <p>
            文件1：<input type="file" name="a" />
            文件2：<input type="file" name="b" />
        </p>
        <p>
            <input type="submit" value="上传" />
        </p>
    </form>
    
    
    
      <form style="border:1px solid red;" method="POST" enctype="multipart/form-data" action="/uploadExcel">
        <p>
            文件1：<input type="file" name="a" />
        </p>
        <p>
            <input type="submit" value="上传" />
        </p>
    </form>
    



<%@include file ="common/t.jsp"%>