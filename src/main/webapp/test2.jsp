<%@page import="java.awt.Color"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="image/png; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
BufferedImage image = new BufferedImage(100, 100,
        BufferedImage.TYPE_INT_RGB);
	// 获取图形上下文
	Graphics g = image.getGraphics();
	g.setColor(Color.green);
	g.fillRect(0, 0, 50, 50);
	g.dispose();
	ServletOutputStream responseOutputStream = response.getOutputStream();
	// 输出图象到页面
	ImageIO.write(image, "JPEG", responseOutputStream);
	// 以下关闭输入流！
	responseOutputStream.flush();
	responseOutputStream.close();
%>