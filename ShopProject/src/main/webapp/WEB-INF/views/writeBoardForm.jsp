<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="writeBoard" method="post">
		<input type="hidden" name="productcode" value="${productCode }">
		<input type="hidden" name="id" value="${sessionScope.loginId }">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" id="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" id="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<a href=""><input class="btn btn-primary" type="submit" value="작성"></a>
					<a href="productView?productCode=${productCode}" class="btn btn-primary">돌아가기</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>