<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복검사</title>
<script type="text/javascript">
	function formCheck() {
		var id = document.getElementById('searchId');
		
		if(id.value == ''){
			alert('ID를 입력해주세요');
			id.focus();
			return false;
		}
		var blank_pattern = /^\s+|\s+$/g;
		if( id.value.replace( blank_pattern, '' ) == "" ){
		    alert("ID를 입력해주세요");
		    return false;
		}
		return true;
	}
	
	function useId() {
		//opener.document.getElementById('custid').value = '${searchId}';
		var id = opener.document.getElementById('custid');
		id.value = '${searchId}';
		this.close();
	}
</script>
</head>
<body>
	<h2>[ ID 중복 확인 ]</h2>
	
	<form action="idSearch" method="post" onsubmit="return formCheck()">
		<input type="text" name="searchId" id="searchId" value="${searchId }" maxlength="8">
		<input type="submit" value="검색">
	</form>
	
	<c:if test="${search }">
		<!-- 검색결과가 없는경우 -->
		<c:if test="${searchResult == null }">
			<p><c:out value="${searchId }"/> : 사용가능한 ID 입니다.</p>
			<input type="button" value="ID사용하기" onclick="useId()">
		</c:if>
		<!-- 검색결과가 있는경우 -->
		<c:if test="${searchResult != null }">
			${searchId } : 이미 사용중인 ID입니다.
		</c:if>
	</c:if>
</body>
</html>