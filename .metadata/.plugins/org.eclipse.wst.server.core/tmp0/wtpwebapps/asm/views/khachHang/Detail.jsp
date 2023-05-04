<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}" />
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/asm/views/Detail.css">

</head>
<body>
	<%@ include file="/views/khachHang/Nav.jsp"%>
	<div class="app_container">
		<div class="row">
			<div class="col-md-8">
				<form class="card_product" method="post">
					<div class="card_img">
						<iframe src="https://www.youtube.com/embed/${video.id}">
						</iframe>
					</div>
					<h5>${video.title }</h5>
					<div class="card_button">
						<button class="card_button__like" name="like" value="${video.id }">Like</button>
						<a style="text-decoration: none;" href="/asm/sendemail/${video.id }"
							class="card_button__share">share</a>
					</div>
				</form>
			</div>
			<div class="col-md-4 ">
			<c:forEach var="item" items="${videos}">
			<a href="/asm/home/detail/videoId=${item.id}" style="text-decoration: none; color: #000;">
				<div class="row">
					<div class="card mb-3">
						<div class="row g-0">
							<div class="col-md-4 border width">
								<img
									src="/asm/${item.poster}"
									class="img-fluid rounded-start" alt="...">
							</div>
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title">${item.title}</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
			</a>
			</c:forEach>
			</div>
		</div>
	</div>



</body>
</html>