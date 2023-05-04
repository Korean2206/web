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
		<%@ include file="/views/khachHang/Nav.jsp" %>

	<div class="app_container">
		<form class="app_form" action="/asm/account/change_password" method="post">
			<div class="form_header">Change Password</div>
			<div class="form_body">
				<div class="col">
					Username? <br> <input type="text" name="username"> <br> New Password?
					<br> <input type="password" name="newPass"> <br>
				</div>
				<div class="col">
					Current Password? <br> <input type="password" name="currentPass"> <br>
					Confirm New Password? <br> <input type="password" name="confirmPass"> <br>
				</div>
			</div>
			<div class="form_footer">
			<span style="color: red;margin-right: 16px;">${message }</span>
				<button>Change</button>
			</div>
		</form>


	</div>
</body>
</html>