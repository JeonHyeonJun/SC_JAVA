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
		//=====================이벤트 함수 on()==============================
		$('h1').on('click',function(event){		//click이벤트
			alert('읭읭');
			//$('h1').off('click');				//이벤트끄기
		});
		
		var test = function(event) {
			alert('click event');
		}
		$('h1').on('click',test);
		
		
		$('h1').on('mouseenter', function() {
			$(this).html(function(index,html) {
				return html + '+';
			});
		});
		
		$('h1').on({
			mouseenter: function() { 
				$(this).addClass('reverse'); 
			}
			,mouseleave: function() { 
				$(this).removeClass('reverse'); 
			}
		});
		
		//=====================이벤트 강제발생 trigger()==============================
		$('h2').click(function() {
			$('> span', this).html(function(index,html) {
				return Number(html)+1;
			});
		});
		
		setInterval(function() {
			$('h2').last().trigger('click');	//h2의 마지막부분에 click이벤트를 발생시킴(클릭안해도 클릭했을때에 이벤트를 실행함!)
		}, 1000);
	});
</script>

<style type="text/css">
	.reverse{
		background : red;
		color : aqua;
	}
</style>
</head>
<body>
	<h1>Header - 0</h1>
	<h1>Header - 1</h1>
	<h1>Header - 2</h1>
	
	<h2>Start: <span>0</span> 클릭</h2>
	<h2>Start: <span>0</span> 초</h2>
</body>
</html>