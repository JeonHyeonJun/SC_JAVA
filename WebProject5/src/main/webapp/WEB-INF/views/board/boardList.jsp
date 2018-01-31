<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 리스트</title>
<style type="text/css">
	table {
		width : 1000px;
		margin: auto;
	}
	th {
		background-color: hotpink;
	}
	td {
		background-color: pink;
		height: 30px;
	}
	input[type="button"] {
		background-color: yellow;
		border-radius: 5px;
		height: 30px;
	}
	html {
		width: 100%;
		height: 100%;
	}
	body { 
		width: 100%;
		height: 100%;
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
	    background-image: url('../resources/img/chiken1.jpeg');
	    background-size: 25%;
	    width: 100%;
	    height: 1000px;
	    opacity : 0.5;
	    z-index: -1;
	}
	.write-btn {
		background-color: transparent;
		text-align: right;
	}
	.ex_img {
		width: 20px;
		height: 20px;
	}
	a:LINK {
		text-decoration: none;
		font-weight: bold;
	}
	a:VISITED {
		color: blue;
	}
	a:HOVER {
		color: red;
	}
	.title {
		font-size : 20px;
		width: 55%;
	}
	.title:HOVER {
		background-color: silver;
	}
	.boardnum {
		width: 10%;
	}
	.id {
		width: 15%;
	}
	.hits {
		width: 5%;
	}
	.inputdate {
		width: 15%;
	}
	.page {
		background-color: transparent; 
		color: aqua;
	}
	.no-bg {
		background-color: transparent; 
	}
	select {
		height: 30px;
		border-radius: 5px;
	}
	input[type="text"] {
		height: 25px;
		border-radius: 5px;
	}
</style>

<script type="text/javascript">
/* window.onload = function(){
	var searchType = document.getElementById('searchType');
	for(var i=0; i<searchType.length; i++){
		if(searchType.options[i].value == '${searchType}'){
			searchType.options[i].selected = true;
		}
	}
} */
	
	function pagingFormSubmit(idx) {
		var form = document.getElementById('pagingForm');
		var page = document.getElementById('page');
		page.value = idx;
		form.submit();
	}
</script>
</head>
<body>
<div class="bg">
	<h1><a href="boardList">[ 글 목록 ]</a></h1>
	
	<table>
		<tr>
			<td class="no-bg">
				<input type="button" value="메인으로" onclick="location.href='.././'">
			</td>
		<c:if test="${sessionScope.id != null }">
			<td colspan="4" class="write-btn">
				<input type="button" value="글쓰기" onclick="location.href='boardWriteForm'">
			</td>
		</c:if>
		</tr>
		<tr>
			<th class="boardnum">번호</th>
			<th>제목</th>
			<th class="id">작성자</th>
			<th class="hits">조회수</th>
			<th class="inputdate">등록일</th>
		</tr>
	<c:forEach items="${boardList}" var="list">
		<tr>
			<td class="boardnum">${list.boardnum }</td>
			<td class="title">
				<a href="boardRead?boardnum=${list.boardnum}&page=${page.currentPage}&searchText=${searchText }&searchType=${searchType }"><c:out value="${list.title }"/></a>
				<c:if test="${list.originalfile != null }">
					<img src="../resources/img/img.png" class="ex_img">
				</c:if>
				(${list.replyCount })
			</td>
			<td class="id"><a href="boardList?searchText=${list.id}&searchType=id"><c:out value="${list.id }"/></a></td>
			<td class="hits">${list.hits }</td>
			<td class="inputdate">${list.inputdate }</td>
		</tr>
	</c:forEach>
	<c:if test="${boardList == '[]'}">
		<tr>
			<td colspan="5">
				검색결과가 없습니다
			</td>
		</tr>
	</c:if>
	</table>
	
	<c:if test="${page.currentPage != 1 && boardList != '[]' }">
		<a href="javascript:pagingFormSubmit(1)">◁◁</a>
		<a href="javascript:pagingFormSubmit(${page.currentPage - 1 })">◀</a>
	</c:if>
	<c:forEach begin="${page.startPageGroup }" end="${page.endPageGroup }" var="idx">
		
		<c:if test="${idx == page.currentPage }">
			<b style="color: red;">${idx }</b> 
		</c:if>
		<c:if test="${idx != page.currentPage }">
			<a href="javascript:pagingFormSubmit(${idx})">${idx}</a> 
		</c:if>
		<c:if test="${idx != page.endPageGroup }">
			|
		</c:if>
	</c:forEach>
	<c:if test="${page.currentPage != page.totalPageCount }">
		<a href="javascript:pagingFormSubmit(${page.currentPage +1 })">▶</a>
		<a href="javascript:pagingFormSubmit(${page.totalPageCount })">▷▷</a>
	</c:if>
	
	<form action="boardList" method="get" id="pagingForm">
		<input type="hidden" name="page" id="page">
		<select name="searchType" id="searchType">
			<option value="title" <c:if test="${searchType == 'title' }"> selected </c:if>>제목</option>
			<option value="content" <c:if test="${searchType == 'content' }"> selected </c:if>>내용</option>
			<option value="id" <c:if test="${searchType == 'id' }"> selected </c:if>>작성자</option>
			<option value="tc" <c:if test="${searchType == 'tc' }"> selected </c:if>>제목+내용</option>
		</select>
		<input type="text" name="searchText" value="${searchText }">
		<input type="button" onclick="pagingFormSubmit(1)" value="검색">
	</form>
	
</div>
</body>
</html>