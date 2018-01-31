<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404 NOT FOUND</title>
</head>
<body>
	<center>
		<h1>에러페이지입니다. 메인으로 돌아가려면 이미지를 클릭해주세요</h1>
		<a href="<%=request.getContextPath()%>/./">
			<img src="<%=request.getContextPath()%>/resources/img/yoksim1.png" width="80%" height="400px"><br>
			<img src="<%=request.getContextPath()%>/resources/img/yoksim2.png" width="80%" height="400px"><br>
		</a>
	</center>
</body>
</html>