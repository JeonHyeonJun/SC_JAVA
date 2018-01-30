<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src='<c:url value="/resources/js/jquery-3.2.1.js"/>'></script>
</head>
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
<body>
	<form action="updateBoard" method="post" enctype="multipart/form-data">
		<input type="hidden" name="productcode" value="${board.productcode }">
		<input type="hidden" name="id" value="${sessionScope.loginId }">
		<input type="hidden" name="num" value="${board.num }">
		<table style="margin: auto">
			<tr>
				<td colspan="2">
					<font style="color: red">*새로운 사진을 올리지 않으면 기존사진으로 등록됩니다</font>
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" id="title" value="${board.title }" maxlength="30"></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><input type="file" name="upload"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" id="content">${board.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<a href=""><input class="btn btn-primary" type="submit" value="작성" onclick="return check()"></a>
					<a href="productView?productCode=${board.productcode}" class="btn btn-primary">돌아가기</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>