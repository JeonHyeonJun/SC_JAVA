<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 폼</title>
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
	    background-image: url('../resources/img/nostudy.jpg');
	    background-size: 25%;
	    width: 100%;
	    height: 730px;
	    opacity : 0.5;
	    z-index: -1;
	}
</style>
<script type="text/javascript">
	<c:if test="${errorMsg != null}">alert('${errorMsg}');</c:if>
	<c:if test="${success != null}">
		if(opener == null){
			location.href = ".././"
		}
		opener.location.href = ".././";
		window.close();
	</c:if>
	function formCheck() { 
		var id = document.getElementById('custid');
		var password = document.getElementById('password');
		
		if(id.value == ''){
			alert("ID를 입력해주세요");
			id.focus();
			return false;
		}
		else if(password.value == ''){
			alert("비밀번호를 입력해주세요");
			password.focus();
			return false;
		}
		
		return true;
	}
	
</script>
</head>
<body>
	<div class="bg">
	<h1>[ 로그인 ]</h1>
	<form action="login" method="post" onsubmit="return formCheck()">
	<table>
		<tr> 
			<th>ID</th> 
			<td>
				<input type="text" name="custid" id="custid">
			</td>
		</tr>
		<tr> 
			<th>비밀번호</th> 
			<td><input type="password" name="password" id="password">
		</tr>
		
	</table>
	<div class="btn-center">
		<input type="submit" value="로그인">
	</div>
	</form>
	</div>
</body>
</html>