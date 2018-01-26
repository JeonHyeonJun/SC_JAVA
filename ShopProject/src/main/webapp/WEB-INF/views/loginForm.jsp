<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인폼</title>
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
				error : function() {
					alert("에러에러");
				}
			});
			
		});
		
	});
</script>

</head>
<body>
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
					<input type="button" value="로그인" id="submit">
					<input type="button" value="메인으로" onclick="location.href='./'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>