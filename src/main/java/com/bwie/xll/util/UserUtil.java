package com.bwie.xll.util;

import javax.servlet.http.HttpServletRequest;

public class UserUtil {
	public static String USERKEY="USERKEY";//在session中的key
	public static void setUser(HttpServletRequest req,String uid) {
		req.getSession().setAttribute(USERKEY, uid);
	}
	
	public static String getUser(HttpServletRequest req) {
		return (String) req.getSession().getAttribute(USERKEY);
	}
}
