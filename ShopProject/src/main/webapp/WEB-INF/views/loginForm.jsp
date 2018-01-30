<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인폼</title>
<link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	.bg{
		text-align: center;
		background-color: #bfff00;
	}
	table {
		margin: auto;
	}
</style>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript">
	$(function() {
		$('#submit').on('click', function() {
			var id = $('#id').val();
			var password = $('#password').val();
			
			$.ajax({
				url : "login",
				type : "post",
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify({
					id : id,
					password : password
				}),
				dataType : "text",
				success : function(data) {
					if(data == 'false'){
						alert("아이디 혹은 비밀번호가 다릅니다");
					}
					else {
						alert("로그인 성공!");
						location.href = "./";
					}
				},
				error : function(e) {
					alert("에러에러");
					alert(JSON.stringify(e));
				}
			});
			
		});
		
	});
</script>

</head>
<body>
	<div class="bg">
		<h1>로그인</h1>
		<hr>
		<form action="login" method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" id="id"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" id="password"></td>
				</tr>
				<tr>		
					<td colspan="2">
						<a href="#" id="submit" class="btn btn-primary">로그인</a>
						<a href="./" class="btn btn-primary">메인으로</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>