<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}" />
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/asm/views/css/Regis.css">

</head>
<body>
	<%@ include file="/views/khachHang/Nav.jsp"%>

	<div class="app_container">
		<form class="app_form" action="/asm/account/registration" method="post">
			<div class="form_header">Registration</div>
			<div class="form_body">
				<div class="col">
					Username? <br> <input type="text" name="username"> <br> 
					Fullname? <br> <input type="text" name="fullname"> <br>
				</div>
				<div class="col">
					Password? <br> <input type="password" name="password"> <br>
					Email? <br> <input type="email" name="email"> <br>
				</div>
			</div>
			<div class="form_footer">
			<span style="color: red;margin-right: 16px;">${message }</span>
				<button>Sign Up</button>
			</div>
		</form>


	</div>
</body>
</html>