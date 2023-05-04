package com.poly.utils;

import com.poly.entity.User;

public class Auth {
	public static User user = null;
	
	public static void clear() {
		user = null;
	}
	public static boolean isLogin() {
		return Auth.user !=null;
	}
	public static boolean isAdmin() {
		return Auth.isLogin() && Auth.user.getAdmin();
	}
}
