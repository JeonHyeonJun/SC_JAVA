<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="resources/css/boardWrite.css" rel="stylesheet">
<link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src='<c:url value="/resources/js/jquery-3.2.1.js"/>'></script>

<script type="text/javascript">
	function check() {
		var title = $('#title').val();
		var content = $('#content').val();
		
		if(title == ''){
			alert("제목을 입력해주세요");
			$('#title').focus();
			return false;
		}
		else if(content == ''){
			alert("내용을 입력해주세요");
			$('#content').focus();
			return false;
		}
	}
</script>
</head>

<body>
	<form action="writeBoard" method="post" enctype="multipart/form-data">
		<input type="hidden" name="productcode" value="${productCode }">
		<input type="hidden" name="id" value="${sessionScope.loginId }">
		<div class="bg">
			<h1 style="text-align: center">리뷰작성</h1>
			<table style="margin: auto;">
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" id="title" maxlength="30"></td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type="file" name="upload"></td>
				</tr>
				<tr>
					<th>별점</th>
					<td>
						<select name="score">
							<option value="5">★★★★★</option>
							<option value="4">★★★★☆</option>
							<option value="3">★★★☆☆</option>
							<option value="2">★★☆☆☆</option>
							<option value="1">★☆☆☆☆</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" id="content"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<a href=""><input class="btn btn-primary" type="submit" value="작성" onclick="return check()"></a>
						<a href="productView?productCode=${productCode}" class="btn btn-primary">돌아가기</a>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>