<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 상세보기</title>

<link href="resources/css/productView.css" rel="stylesheet">
<link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src='<c:url value="/resources/js/jquery-3.2.1.js"/>'></script>

</head>
<body>
	<div class="bg">
		<h1>상품정보</h1>
	
	<table border="1" class="product_table" id="product">
		<tr>
			<td>상품명</td>
			<td>${product.productName}</td>
		</tr>
		<tr>
			<td>가격</td>
			<td>${product.productPrice}</td>
		</tr>
		<tr>
			<td>상품이미지</td>
			<td>
				<a href="http://www.11st.co.kr/product/SellerProductDetail.tmall?method=getSellerProductDetail&prdNo=${product.productCode }">
					<img src="${product.basicImage }" class="productimg">
				</a>
			</td>
		</tr>
		<tr>
			<td>상세정보</td>
			<td>제품의 상세정보를 보시려면 이미지를 클릭해 주세요</td>
		</tr>
	</table>
	<br>
	<a class="btn btn-primary" href="./?text=${text }">메인으로</a>
	<br><br>
	
	<table class="board_table" >
		<tr>
			<td colspan="4" style="text-align: left"><h1>제품리뷰</h1></td>
		</tr>
		<c:if test="${sessionScope.loginId != null }">
			<tr>
				<td colspan="4" class="" style="text-align: right"><a class="btn btn-primary" href="writeBoardForm?productCode=${product.productCode }">리뷰쓰기</a></td>
			</tr>
		</c:if>
	<c:forEach items="${boardList }" var="list">
		<tr>
			<td><img src="download?num=${list.num}" onerror="this.src='resources/img/no_image.jpg'" width="100px" height="100px"></td>
			<td width="60%"><a href="boardView?num=${list.num }"><c:out value="${list.title }"/></a></td>
			<td width="10%">
				<c:if test="${list.score == 5 }">★★★★★</c:if>
				<c:if test="${list.score == 4 }">★★★★☆</c:if>
				<c:if test="${list.score == 3 }">★★★☆☆</c:if>
				<c:if test="${list.score == 2 }">★★☆☆☆</c:if>
				<c:if test="${list.score == 1 }">★☆☆☆☆</c:if>
			</td>
			<td width="20%">${list.id }</td>
			<td width="10%">${list.indate }</td>
		</tr>
		
	</c:forEach>
	</table>
	</div>
</body>
</html>