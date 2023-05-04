<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}" />
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/asm/views/css/Favorite.css">

</head>
<body>
	<%@ include file="/views/khachHang/Nav.jsp"%>

	<div class="app_container">
		<form class="row" action="/asm/favorite" method="post">
			<c:forEach var="item" items="${videos }">
				<div class="col">
					<div class="card_product">
						<a href="/asm/home/detail/videoId=${item.id}"
							style="text-decoration: none; color: #000;">
							<div class="card_img">
								<img alt="" src="/asm/${item.poster}" />
							</div>
							<h5 style="border: solid 1px red;
		padding: 10px;
		background-color: #b2efb7;
		margin: 0;
		font-weight: bold;
		font-size: 16px;" class="card_title">${item.title}</h5>
						</a>
						<div class="card_button">
							<button class="card_button__unlike" name="unlike"
								value="${item.id}">Unlike</button>
							<a href="/asm/sendemail/${item.id}"
								style="text-decoration: none;" class="card_button__share">share</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</form>


	</div>
</body>
</html>