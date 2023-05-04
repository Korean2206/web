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
		<form class="app_form" method="post">
			<div class="form_header">SEND VIDEO TO YOUR FRIEND</div>
			<div class="form_body">
					<label>Your Friend's Email?</label>
					<br> <input type="email" name="email"> <br>		
			</div>
			<div class="form_footer">
			<span style="color: red; margin-right: 16px;">${message }</span>
				<button>Send</button>
			</div>
		</form>


	</div>
</body>
</html>