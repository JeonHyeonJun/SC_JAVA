<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글읽기</title>
<style type="text/css">
	table {
		width : 700px;
		margin: auto;
	}
	th {
		background-color: aqua;
		width: 10%;
	}
	td {
		background-color: skyblue;
	}
	h1 {
		text-align: center;
	}
	input[type="button"] {
		background-color: pink;
		border-radius: 5px;
		height: 30px;
	}
	input[type="submit"] {
		background-color: pink;
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
		background-image: url('../resources/img/purin.jpg');
		background-size: 50%;
	}
	.bg {
		position: relative;
	}
	.bg:after {
		content : "";
	    display: block;
	    position: absolute;
	    top: 0;
	    left: 0;
	    background-size: 25%;
	    width: 100%;
	    height: 100%;
	    opacity : 0.5;
	    z-index: -1;
	}
	.btn {
		background-color: transparent;
		text-align: center;
	}
	pre{
		overflow: auto;
		white-space: pre-wrap;
	}
	.ex_img {
		width: 300px;
		height: 300px;
	}
	.replyWriteFrom{
		text-align: center;
	}
	textarea{
		width: 300px;
		height: 50px;
		resize: none;
	}
	.no-bg {
		background: transparent;
		font-size: 30px;
		font-weight: bold;
		color: white;
	}
	.text {
		width: 600px;
	}
	pre {
		font-size: 15px;
		font-weight: bold;
	}
</style>
<script type="text/javascript">
	function del(num, b_id) {
		var form = document.getElementById('deleteForm');
		var boardnum = document.getElementById('d_boardnum');
		var id = document.getElementById('d_id');
		
		if(confirm('삭제하시겠습니까?')){
			boardnum.value = num;
			id.value = b_id;
			form.submit();
		}
	}
	
	function upd(num, u_id) {
		var form = document.getElementById('updateForm');
		var boardnum = document.getElementById('u_boardnum');
		var id = document.getElementById('u_id');
		
		if(confirm('수정하시겠습니까?')){
			boardnum.value = num;
			id.value = u_id;
			form.submit();
		}
	}
	
	function replyCheck() {
		var text = document.getElementById('text');
		var blank_pattern = /^\s+|\s+$/g;
		
		if(text.value == '' || text.value.replace( blank_pattern, '' ) == ""){
			alert("댓글을 입력해 주세요");
			text.focus();
			return false;
		}
		else if(text.value.length > 50){
			alert("댓글은 50자까지 작성가능합니다");
			text.focus();
			return false;
		}
		return true;
	}
	
	function deleteReply(replynum,boardnum) {
		var form = document.getElementById('replyDeleteForm');
		var b_num = document.getElementById('reply_d_boardnum');
		var r_num = document.getElementById('reply_d_replynum');
		
		if(confirm('삭제합니까?')){
			b_num.value = boardnum;
			r_num.value = replynum;
			form.submit();
		}
	}
	function replyCancle(boardnum) {
		if(confirm('취소하시겠습니까?')){
			location.href="boardRead?boardnum="+boardnum+"&page=${params.page}&searchText=${params.searchText }&searchType=${params.searchType}";
		}
		
	}

	function updateReplyForm(replynum, boardnum, text) {
		var div = document.getElementById('div'+replynum);
		/* <c:forEach items="${reply}" var="reply">
			var r_num = ${reply.replynum};
			var b_num = ${reply.boardnum};
			var r_text = '${reply.text}';
			if('${sessionScope.id}' == '${reply.id}')
				replyCancle(r_num,b_num,r_text);
		</c:forEach>  */
		var str = '<form action="updateReply" method="post" onsubmit="return updateCheck('+replynum+')">'
				+ '<textarea name="text" id="text'+replynum+'">'+text+'</textarea>'
				+ '<input type="hidden" name="replynum" value="'+replynum+'">'
				+ '<input type="hidden" name="boardnum" value="'+boardnum+'">'
				+ '<input type="hidden" name="page" value="${params.page}">'
				+ '<input type="hidden" name="searchText" value="${params.searchText }">'
				+ '<input type="hidden" name="searchType" value="${params.searchType }">'
				+ '<input type="submit" value="수정" >'
				+ '<input type="button" value="취소" onclick="replyCancle('+boardnum+')">'
				+ '</form>';	
		div.innerHTML = str;
	}
	
	function updateCheck(replynum) {
		var text = document.getElementById('text'+replynum);
		var blank_pattern = /^\s+|\s+$/g;
		
		if(text.value == '' || text.value.replace( blank_pattern, '' ) == ""){
			alert("댓글을 입력해 주세요");
			text.focus();
			return false;
		}
		else if(text.value.length > 50){
			alert("댓글은 50자까지 작성가능합니다");
			text.focus();
			return false;
		}
		return true;
	}
	
	function replyForm(replynum, boardnum, groupnum, groupseq) {
		var div = document.getElementById('reply'+replynum);
		var seq = groupseq+1;
		var str = '<form action="insertReply" method="post">'
		+ '<textarea name="text"></textarea>'
		+ '<input type="hidden" name="replynum" value="'+replynum+'">'
		+ '<input type="hidden" name="boardnum" value="'+boardnum+'">'
		+ '<input type="hidden" name="page" value="${params.page}">'
		+ '<input type="hidden" name="searchText" value="${params.searchText }">'
		+ '<input type="hidden" name="searchType" value="${params.searchType }">'
		+ '<input type="hidden" name="groupnum" value="'+groupnum+'">'
		+ '<input type="hidden" name="groupseq" value="'+seq+'">'
		+ '<input type="hidden" name="parentnum" value="'+replynum+'">'
		+ '<input type="submit" value="답글작성" >'
		+ '</form>';	
		div.innerHTML = str;
	}
</script>
</head>
<body>
<div class="bg">
	<h1>[ 게시판 글읽기 ]</h1>
	<table>
		<tr>
			<th>작성자</th>
			<td><c:out value="${board.id}"/></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${board.inputdate}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.hits}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><c:out value="${board.title}"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><pre><c:out value="${board.content}"/></pre></td>
		</tr>
		<tr>
			<th>파일</th>
			<td>
				<a href="download?boardnum=${board.boardnum}">${board.originalfile }</a>
			</td>
		</tr>
		<c:if test="${board.originalfile != null }">
			<tr>
				<th>미리보기</th>
				<td>
					<img src="download?boardnum=${board.boardnum}" class="ex_img">
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan="2" class="btn">
				<c:if test="${sessionScope.id == board.id }">
					<input type="button" value="수정" onclick="upd(${board.boardnum},'${sessionScope.id}')">
					<input type="button" value="삭제" onclick="del(${board.boardnum},'${sessionScope.id}')">
				</c:if>
				<input type="button" value="목록" onclick="location.href='boardList?page=${params.page}&searchText=${params.searchText }&searchType=${params.searchType}'">
			</td>
		</tr>
	</table>
	<br><br>
	
	<table>
		<tr>
			<td colspan="3" class="no-bg">댓글 ${replyCnt }개</td>
		</tr>
		<c:forEach items="${reply}" var="reply">
			<tr>
				<th style="width: 15%"><c:out value="${reply.id }"/></th>
				<c:if test="${reply.replydel == 'N' }">
				<td style="width: 50%">
					<div id="div${reply.replynum }">
					<c:forEach begin="1" end="${reply.groupseq }">
					&nbsp;
					</c:forEach>
					<c:if test="${reply.groupseq != 0}">
					<font color="yellow">ㄴ</font>
					</c:if>
					${reply.text }
					</div>
					<div id="reply${reply.replynum }"></div>
				</td>
				<td style="width: 20%">
					${reply.inputdate }
					<c:if test="${reply.id == sessionScope.id }">
						<a href="javascript:updateReplyForm('${reply.replynum}','${reply.boardnum }','<c:out value="${reply.text}"/>' )">수정</a>
						<a href="javascript:deleteReply('${reply.replynum}','${reply.boardnum }')">삭제</a>
					</c:if>
					<c:if test="${sessionScope.id != null }">
						<a href="javascript:replyForm('${reply.replynum}','${reply.boardnum }', '${reply.groupnum }', ${reply.groupseq })">답글</a>
					</c:if>
				</td>
				</c:if>
				<c:if test="${reply.replydel == 'Y' }">
					<td colspan="2">
						<c:forEach begin="1" end="${reply.groupseq }">
						&nbsp;
						</c:forEach>
						<c:if test="${reply.groupseq != 0}">
							<font color="yellow">ㄴ</font>
						</c:if>
						<font color="gray">삭제된 댓글 입니다.</font>
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>

	<div class="replyWriteFrom">
		<form action="insertReply" method="post" onsubmit="return replyCheck()">
			<c:if test="${sessionScope.id != null }">
				<input type="hidden" name="boardnum" value="${board.boardnum}">
				<input type="hidden" name="page" value="${params.page}">
				<input type="hidden" name="searchText" value="${params.searchText }">
				<input type="hidden" name="searchType" value="${params.searchType }">
				<input type="hidden" name="groupnum" value="0">
				<input type="hidden" name="groupseq" value="0">
				<input type="hidden" name="parentnum" value="0">
				<textarea name="text" id="text" class="text"></textarea>
				<input type="submit" value="댓글달기">
			</c:if>
		</form>
		</div>
	</div>

<form action="boardDelete" id="deleteForm" method="post">
	<input type="hidden" name="boardnum" id="d_boardnum">
	<input type="hidden" name="id" id="d_id"> 
</form>

<form action="boardUpdateForm" id="updateForm" method="post">
	<input type="hidden" name="boardnum" id="u_boardnum">
	<input type="hidden" name="id" id="u_id">
	<input type="hidden" name="page" value="${params.page}">
	<input type="hidden" name="searchText" value="${params.searchText }">
	<input type="hidden" name="searchType" value="${params.searchType }">
</form>

<form action="deleteReply" id="replyDeleteForm" method="post">
	<input type="hidden" name="boardnum" id="reply_d_boardnum">
	<input type="hidden" name="replynum" id="reply_d_replynum">
	<input type="hidden" name="page" value="${params.page}">
	<input type="hidden" name="searchText" value="${params.searchText }">
	<input type="hidden" name="searchType" value="${params.searchType }">
</form>

</body>
</html>