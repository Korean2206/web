<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/asm/views/khachHang/Home.css">

</head>
<body>
	<%@ include file="/views/khachHang/Nav.jsp"%>

	<form class="app_container" action="/asm/home" method="post">
		<div class="row">
			<c:forEach var="item" items="${videos}" >
				<div class="col">
					<div class="card_product">
						<a href="/asm/home/detail/videoId=${item.id}"
							style="text-decoration: none; color: #000;">
							<div class="card_img">
								<img alt="" src="/asm/${item.poster}" />
							</div>
							<h5 class="card_title">${item.title}</h5>
						</a>
						<div class="card_button">
							<a href="/asm/favorite/${item.id}" style="cursor: pointer; text-decoration: none;" class="card_button__like">Like</button>
							<a href="/asm/sendemail/${item.id }" style="text-decoration: none;"
								class="card_button__share">share</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<div class="row">
			<div class="footer_button">
				<button>|<</button>
				<button><<</button>
				<button>>></button>
				<button>>|</button>
			</div>
		</div>
	</form>
</body>
</html>