<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/asm/test" method="post" enctype="multipart/form-data">
	<input type="file" name="photo_file">
	<img alt="" src="/asm/img/${message.name }">
	<button>test</button>
</form>
</body>
</html>