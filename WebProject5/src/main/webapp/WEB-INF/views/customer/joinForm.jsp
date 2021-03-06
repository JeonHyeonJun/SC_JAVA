<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입폼</title>
<link href="../resources/css/joinForm.css" type="text/css" rel="stylesheet">
<style type="text/css">
	html {
		width: 100%;
		height: 100%;
	}
	body { 
		width: 100%;
		height: 100%;
		overflow: hidden;
	}
	.bg {
		position: relative;
		text-align: center;
	}
	.bg:after {
		content : "";
	    display: block;
	    position: absolute;
	    top: 0;
	    left: 0;
	    background-image: url('../resources/img/hyunta2.jpeg');
	    background-size: 50%;
	    width: 100%;
	    height: 750px;
	    opacity : 0.3;
	    z-index: -1;
	}
</style>
<script type="text/javascript">
	<c:if test="${errorMsg != null }">alert('${errorMsg }');</c:if>
	function idcheckOpen() {
		window.open("idCheck", "newWindow", "top=200, left=400, height=300, width=400, resizable=no");
	}
	
	function formCheck() { 
		var id = document.getElementById('custid');
		var password = document.getElementById('password');
		var password2 = document.getElementById('password2');
		var name = document.getElementById('name');
		var email = document.getElementById('email');
		var idno = document.getElementById('idno');
		var address = document.getElementById('address');
		
		if(id.value == ''){
			alert("ID를 입력해주세요");
			return false;
		}
		else if(password.value == ''){
			alert("비밀번호를 입력해주세요");
			password.focus();
			return false;
		}
		else if(password2.value == ''){
			alert("비밀번호를 한번 더 입력해주세요");
			password2.focus();
			return false;
		}
		else if(password.value != password2.value){
			alert("비밀번호가 일치하지 않습니다");
			password2.focus();
			return false;
		}
		else if(name.value == ''){
			alert("이름을 입력해주세요");
			name.focus();
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<div class="bg">
	<h1>[ 회원가입 ]</h1>
	<form action="join" method="post" onsubmit="return formCheck()">
	<table>
		<tr> 
			<th>ID</th> 
			<td>
				<input type="text" name="custid" id="custid" readonly="readonly" value="${customer.custid }" placeholder="ID중복확인 이용">
			</td>
			<td><input type="button" value="중복확인" onclick="idcheckOpen()"></td>
		</tr>
		<tr> 
			<th>비밀번호</th>  
			<td><input type="password" name="password" id="password" value="${customer.password }" placeholder="비밀번호 입력" maxlength="15">
			<br><input type="password" id="password2" placeholder="비밀번호 다시 입력" maxlength="15"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" id="name" value="${customer.name }" placeholder="이름 입력" maxlength="10"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email" id="email" value="${customer.email }" placeholder="이메일 입력" maxlength="30"></td>
		</tr>
		<tr>
			<th>고객구분</th>
			<td>
				<input type="radio" name="division" value="personal" checked="checked">개인
				<input type="radio" name="division" value="company">기업
			</td>
		</tr>
		<tr>
			<th>식별번호</th>
			<td><input type="text" name="idno" id="idno" value="${customer.idno }" placeholder="개인:주민번호/법인:사업자" maxlength="20"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="address" id="address" value="${customer.address }" placeholder="주소 입력" maxlength="30"></td>
		</tr>
	</table>
	<div class="btn-center">
		<input type="submit" value="가입">
		<input type="reset" value="다시 쓰기">
		<input type="button" value="메인으로" onclick="location.href='.././'">
	</div>
	</form>
	</div>
</body>
</html>