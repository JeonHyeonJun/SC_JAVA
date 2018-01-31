<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript">
	$(function() {
		//홀수번째 위치한 태그만 선택
		$('h3:even').css({
			backgroundColor: 'black',
			color: 'white'
		});
		//둘이 같은 기능임
		$('h3').filter(':even').css({
			backgroundColor: 'black',
			color: 'white'
		});
		
		
		$('h3').eq(0).css('background', 'orange');
		$('h3').eq(-1).css('background', 'red');	//뒤에서 첫번째
		
		
		$('#div1').find('a').each(function(index, item) {
			$(item).attr("href","http://www.naver.com");
		});
			
		/*  parent() = 부모 
			prev() = 형제중에 이전
			next() = 형제중에 다음
			find() = 안쪽에 모든 대상
			closest() = 가장 가까운 부모
		*/
		
		$('#a1').parent().prev().find("a").each(function(index, item) {
			alert(item);
		});
	
	});
</script>
</head>
<body>
	<h3>Header - 0</h3>
	<h3>Header - 1</h3>
	<h3>Header - 2</h3>
	<h3>Header - 3</h3>
	<h3>Header - 4</h3>
	<h3>Header - 5</h3>
	
	<div id="div1">
		<ul>
			<li>li - 0</li>
			<li><a>li - 1</a></li>
			<li><a>li - 2</a></li>
			<li><a id="a1">li - 3</a></li>
		</ul>
	</div>
</body>
</html>