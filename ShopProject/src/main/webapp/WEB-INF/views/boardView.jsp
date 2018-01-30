<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 상세보기</title>
<link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src='<c:url value="/resources/js/jquery-3.2.1.js"/>'></script>

<script type="text/javascript">
	function del(num, id, productcode) {
		if(confirm('삭제하시겠습니까?')){
			$('#d_num').val(num);
			$('#d_id').val(id);
			$('#d_productcode').val(productcode);
			$('#delform').submit();
		}
	}
	
	function upd(num) {
		if(confirm('수정하시겠습니까?')){
			$('#u_num').val(num);
			$('#updform').submit();
		}
	}
</script>
</head>
<body>
	<div style="width: 90%; height:100%; margin: auto; background-color: #bfff00; text-align: center" >
		<h1>제품리뷰</h1>
	
	<table border="1" style="margin: auto" width="1000px">
		<tr>
			<th width="10%">제목</th>
			<td width="60%"><c:out value="${board.title}"/></td>
			<th width="10%">작성자</th>
			<td width="20%">${board.id }</td>
		</tr>
		<tr>
			<th>사진</th>
			<td colspan="3" style="text-align: left"><img src="download?num=${board.num }" onerror="this.src='resources/img/no_image.jpg'" width="300px" height="200px"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3" style="text-align: left"><c:out value="${board.content}"/></td>
		</tr>
		
	</table>
	<br>
		<c:if test="${sessionScope.loginId == board.id }">
			<a class="btn btn-primary" href="javascript:upd(${board.num })">수정</a>
			<a class="btn btn-primary" href="javascript:del(${board.num },'${sessionScope.loginId }','${board.productcode }')">삭제</a>
		</c:if>
		<a class="btn btn-primary" href="productView?productCode=${board.productcode }">뒤로가기</a>
		<a class="btn btn-primary" href="./">메인으로</a>
	<br><br>
	
	
	</div>
	
	<form action="deleteBoard" method="post" id="delform">
		<input type="hidden" name="num" id="d_num">
		<input type="hidden" name="id" id="d_id">
		<input type="hidden" name="productcode" id="d_productcode">
	</form>
	
	<form action="updateBoardForm" method="post" id="updform">
		<input type="hidden" name="num" id="u_num">
	</form>
</body>
</html>