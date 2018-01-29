<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>S&C Master Shop</title>
	<link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar-light bg-light static-top">
      <div style="background-color: hotpink; padding-left: 10%">
        <a class="navbar-brand" href="./">S&C Master</a>
	        <c:if test="${sessionScope.loginId == null }">
		        <a class="btn btn-primary" href="insertCustomerForm">회원가입</a>
		        <a class="btn btn-primary" href="loginForm">로그인</a>
	        </c:if>
	        <c:if test="${sessionScope.loginId != null }">
	        	<font color="aqua">${sessionScope.loginName}</font>님 로그인중
	        	<a class="btn btn-primary" href="logout">로그아웃</a>
	        	<a class="btn btn-primary" href="cart">장바구니</a>
	        </c:if>
      </div>
    </nav>
</body>
</html>