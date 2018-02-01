<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	.bg{
		text-align: center;
	}
	table {
		margin: auto;
	}
	input[type="text"]{
		width: 300px;
		border-radius: 5px;
	}
	input[type="password"]{
		width: 300px;
		border-radius: 5px;
	}
</style>
<script type="text/javascript" src='<c:url value="/resources/js/jquery-3.2.1.js"/>'></script>
<script type="text/javascript">
	$(function() {
		$('#id').on('blur keyup', function() {
			var id = $(this).val();
			if(id == ''){
				$('#idcheck').text('');
				return;
			}
			var idchk = /^[a-zA-Z0-9]+$/;
			$.ajax({
				url : 'idcheck',
				type : 'get',
				data : {
					id : id
				},
				dataType : 'text',
				success : function(data) {
					if(!idchk.test(id)){
						$('#idcheck').text('아이디는 영소문자와 숫자만 사용가능');
					}
					else if(data == 'true')
						$('#idcheck').text('사용가능');
					else
						$('#idcheck').text('중복');
				},
				error : function() {
					alert("에러에러");
				}
			});
		});
	});
	
	function check() {
		var idchk = /^[a-zA-Z]+$/;
		var emailchk = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
		var phonechk = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/;
		var passchk = /^[a-z0-9_]{4,15}$/;		//4~15자,소문자,숫자,언더바사용가능
		var id = $('#id').val();
		var password = $('#password').val();
		var password2 = $('#password2').val();
		var name = $('#name').val();
		var phone = $('#phone').val();
		var email = $('#email').val();
		
		if(id == ''){
			alert("아이디를 입력해주세요");
			$('#id').focus();
			return false;
		}
		
		else if($('#idcheck').text() != '사용가능'){
			alert("아이디를 확인해주세요");
			$('#id').focus();
			return false;
		}
		else if(password == ''){
			alert("비밀번호를 입력해주세요");
			$('#password').focus();
			return false;
		}
		else if(password2 == ''){
			alert("비밀번호를 한번 더 입력해주세요");
			$('#password2').focus();
			return false;
		}
		else if(password != password2){
			alert("비밀번호가 일치하지 않습니다");
			$('#password2').focus();
			return false;
		}
		else if(name == ''){
			alert("이름을 입력해주세요");
			$('#name').focus();
			return false;
		}
	}
</script>
</head>
<body>
	<div class="bg">
		<h1>회원가입</h1>
		<p><font color="red">*</font>표시 항목은 필수항목입니다.</p>
		<hr>
		<form action="insertCustomer" method="post">
			<table>
				<tr>
					<th>아이디<font color="red">*</font></th>
					<td><input type="text" name="id" id="id" autocomplete="off" maxlength="15" placeholder="ID는 영문자,숫자 15자이하"></td>
					<td id="idcheck"></td>
				</tr>
				<tr>
					<th>비밀번호<font color="red">*</font></th>
					<td><input type="password" name="password" id="password" maxlength="15" placeholder="15자이하"></td>
				</tr>
				<tr>
					<th>비밀번호확인<font color="red">*</font></th>
					<td><input type="password" name="password2" id="password2" maxlength="15" placeholder="15자이하"></td>
				</tr>
				<tr>
					<th>이름<font color="red">*</font></th>
					<td><input type="text" name="name" id="name" maxlength="6" placeholder="6자이하"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="phone" id="phone" maxlength="15"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" id="email" maxlength="30"></td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="#"><input type="submit" value="가입" onclick="return check()" class="btn btn-primary"></a>
						<a href="./" class="btn btn-primary">돌아가기</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>