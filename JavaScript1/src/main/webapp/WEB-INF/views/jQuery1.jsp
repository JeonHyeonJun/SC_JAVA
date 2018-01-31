<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
	});
	//둘이 같음
	$(function() {
		$('h1').css('color', 'aqua');
		$('#header1').css('color', 'red');
		$('.h1').css('border', '2px solid black');
		//$('div > *').css('color', 'silver');	//자손선택자. ul까지만 silver가 붙음
		$('div *').css('color', 'silver');	//후손선택자. li까지 silver가 붙음
		$('div p').css('color', 'hotpink');	
	});
</script>
</head>
<body>
	<h1 id="header1" class="h1">개미는</h1>
	<h1 id="header2" class="h2">개미는</h1>
	<p class="h1">Power!</p>
	
	<div>
		<ul>
			<li>Bad Apple</li>
			<li>Bag Apple</li>
			<li>Cat Apple</li>
			<li>Dog Apple</li>
			<li>Elephant</li>
		</ul>
		<span>
			<p>피</p>
		</span>
	</div>
	
	<ul>
		<li>Bad Apple2</li>
		<li>Bag Apple2</li>
		<li>Cat Apple2</li>
		<li>Dog Apple2</li>
		<li>Elephant2</li>
	</ul>
</body>
</html>