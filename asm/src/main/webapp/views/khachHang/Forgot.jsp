<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}" />
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/asm/views/css/Forgot.css">

</head>
<body>
		<%@ include file="/views/khachHang/Nav.jsp" %>

	<div class="app_container">
		<form class="app_form" action="/asm/account/forgot_password" method="post">
			<div class="form_header">Forgot Password</div>
			<div class="form_body">
					Username? <br> <input type="text" name="username"> <br>
					Email? <br> <input type="email" name="email"> <br>		
			</div>
			<div class="form_footer">
			<span style="color: red;margin-right: 16px">${message }</span>
				<button>Retrieve</button>
			</div>
		</form>


	</div>
</body>
</html>