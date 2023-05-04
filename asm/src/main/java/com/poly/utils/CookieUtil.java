package com.poly.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieUtil {
	public static Cookie add(String name,String value,int hours,HttpServletResponse resp) {
		Cookie c = new Cookie(name,value);
		c.setMaxAge(hours*60*60);
		c.setPath("/");
		resp.addCookie(c);
		return c;
	}
	public static String get(String name,HttpServletRequest req) {
		Cookie[] c = req.getCookies();
		if(c != null) {
			for(Cookie cookie : c) {
				if(cookie.getName().equalsIgnoreCase(name)) {
					return cookie.getValue();
				}
			}
		}
		return "";
	}
}
