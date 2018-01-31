<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TEST!</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript">
	$(function() {
		$('#bt1').click(function() {
			
			$.ajax({
				url : "ajaxtest1",		//url로 요청을 보냄	
				type : "get",			//보낼방식
				dataType : "text",		//결과로 받을 데이터 타입
				success : function(data) {
					alert("成功！");
					alert(data);
				},
				error : function() {
					alert("失敗！");
				}
			});
			
		});
		
		$('#bt2').on('click', function() {
			$.ajax({
				url : "ajaxtest2",
				type : "post",
				data : {
					str : "아나타노 오나마에오 오시에테 쿠다사이"
				},
				dataType : "text",
				success : function(d) {
					alert(d);
					$('div').html('<img src="'+d+'">');
				},
				error : function(e) {
					alert(JSON.stringify(e));
				}
			});
		});
		
		
		
	});
</script>
</head>
<body>
	<input type="button" id="bt1" value="서버로요청보내기">
	<input type="button" id="bt2" value="서버로 문자열 보내기 / 받기">
	<input type="text" id="text1">
	<div></div>
</body>
</html>