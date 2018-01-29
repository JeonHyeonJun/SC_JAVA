<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장바구니</title>
</head>

<body>
	<br>
	<c:if test="${sessionScope.cart == null}">
		<h1 style="text-align: center;">장바구니에 담은 물건이 없습니다.</h1>
	</c:if>
	<table border="1" style="margin: auto;">
		<c:forEach items="${sessionScope.cart }" var="cart">
		<tr>
			<td>${cart.productCode }</td>
			<td>${cart.productName }</td>
			<td>${cart.productPrice }</td>
			<td><img src="${cart.basicImage }" width="100px" height="100px"></td>
			<td><a href="javascript:alert('이히히 못사!')">구매</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>