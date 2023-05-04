<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/asm/views/css/Login.css">

</head>
<body>

	<%@ include file="/views/khachHang/Nav.jsp"%>

	<div class="app_container">
		<form class="app_form" action="/asm/account/login"  method="post">
			<div class="form_header">Login</div>
			<div class="form_body">
				Username? <br> <input type="text" name="username" value="${username }"> <br>
				Password? <br> <input type="password" name="password"value="${password }">
				<br>
				<div class="remember">
					<input type="checkbox" name="remember"> Remember Me?
				</div>
			</div>
			<div class="form_footer">
			<span style="color: red; margin-right: 16px;">${message }</span>
				<button>Login</button>
			</div>
		</form>
	</div>
</body>
</html>