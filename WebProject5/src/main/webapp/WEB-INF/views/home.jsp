<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	
<style type="text/css">
	html {
		width: 100%;
		height: 100%;
	}
	body { 
		width: 100%;
		height: 100%;
		overflow: hidden;
		background-image: url("resources/img/dog.gif");
		background-size : 25%;
		text-align: center;
		vertical-align: middle;
		line-height: 100px;
	}
	h1 {
		color: hotpink;
		text-shadow: 3px 3px #333; 
	}
	a {
		background-color: aqua;
		color: red;
		font-size: 30px;
		border-radius: 5px;
	}
	.login {
		text-shadow: 2px 2px #333; 
		background-color: white;
		color: 	#ADFF2F;
		font-size: 20px;
		font-weight: bold;
	}
</style>

<script type="text/javascript">
	function loginForm() {
		window.open('customer/loginForm','loginForm', "top=200, left=400, height=300, width=400, resizable=no");
	}
</script>
</head>
<body>
	<h1>[ Spring 최후의 게시판 ]</h1>
	<c:if test="${sessionScope.id == null }">
		<p><a href="customer/joinForm">회원 가입</a></p>
		<p><a href="javascript:loginForm()">로그인</a></p>
		<p><a href="board/boardList">게시판</a></p>
	</c:if>
	
	<c:if test="${sessionScope.id != null }">
		<p class="login">${sessionScope.name}(${sessionScope.id})님 로그인 중</p>
		<p><a href="customer/logout">로그아웃</a></p>
		<p><a href="customer/updateForm">개인정보 수정</a></p>
		<p><a href="board/boardList">게시판</a></p>
	</c:if>
</body>
</html>
