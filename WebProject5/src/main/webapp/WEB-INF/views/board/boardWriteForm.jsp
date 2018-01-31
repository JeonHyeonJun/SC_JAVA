<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
<link href="../resources/css/writeForm.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
	function formcheck() {
		var title = document.getElementById('title');
		var content = document.getElementById('content');
		

		if(title.value == ''){
			alert("제목을 입력해주세요");
			title.focus();
			return false;
		}
		
		var blank_pattern = /^\s+|\s+$/g;
		if( title.value.replace( blank_pattern, '' ) == "" ){
		    alert("공백만 입력되었습니다");
		    return false;
		}
		else if(content.value == ''){
			alert("내용을 입력해주세요");
			content.focus();
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
<div class="bg">
	<h1>[ 글쓰기 ]</h1>
	<form action="boardWrite" method="post" onsubmit="return formcheck()" enctype="multipart/form-data">
		<input type="hidden" name="id" id="id" value="${sessionScope.id }">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" id="title" maxlength="20"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" id="content"></textarea>
				</td>
			</tr>
			<tr>
				<th>파일첨부</th>
				<td>
					<input type="file" name="upload">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="btn-center">
					<input type="submit" value="작성">
					<input type="button" value="돌아가기" onclick="location.href='boardList'">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>