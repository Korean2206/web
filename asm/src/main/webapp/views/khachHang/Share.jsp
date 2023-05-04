<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}" />
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/asm/views/Login.css">

</head>
<body>
		<%@ include file="/views/khachHang/Nav.jsp" %>

	<div class="app_container">
		<div class="app_form">
			<div class="form_header">SEND VIDEO TO YOUR FRIEND</div>
			<div class="form_body">
				Your friend's email?  <br>
				<input type="email"> <br>
				
			</div>
			<div class="form_footer">
			<button>Send</button>
			</div>
		</div>
		
		
	</div>
</body>
</html>