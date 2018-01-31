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
		$('p').addClass("test");
		
		//=======================attr함수,prop함수============================
		//attr함수(값만 가져오기)
		//html태그에 있던 값을 가져옴(String으로 나옴)
		var href = $('a').attr('href');			//a태그의 href값을 가져옴
		var chk = $('#chk').attr('scmaster');	//#chk의 scmaster라는 커스텀값을 가져옴
		//prop함수
		//javascript객체로 만들어진 값을 가져옴(결과에 맞는 자료형으로 나옴)
		var href2 = $('a').prop('href');
		
		//attr함수 값 넣기
		$('#chk').attr('checked', 'checked');	//#chk의 checked속성의 checked값을 넣음 
		//prop함수 값 넣기
		$('#chk').prop('checked', true);		//#chk의 checked속성의 checked값을 넣음 
		
		console.log(href);	//#none
		console.log(href2);	//http://localhost:8888/js1/jQuery4#none
		
		var check = $('#chk').attr('checked');
		var check2 = $('#chk').prop('checked');
		var chk2 = $('#chk').prop('scmaster');	
		
		console.log(check);		//checked
		console.log(check2);	//true
		console.log(chk);		//34기
		console.log(chk2);		//undefined
		
		//=======================css적용방법============================
		//css적용
		$('a').css('color','red');									//css하나만넣기
		$('a').css('color','aqua').css('background','#dddddd');		//css여러개넣기
		$('a').css(													//css여러개넣기2
				{'background-color':'yellow', 'font-size':'200%'}
				);
		
		
		//=======================html함수,text함수============================
		var html = $('h1').html();
		//alert(html);								//Header - 0
		var text = $('h1').text();
		//alert(text);								//Header - 0Header - 2Header - 1
		
		$('div').html('<h1>$().html()</h1>');		//html함수는 태그를 적용시킴
		$('div').text('<h1>$().html()</h1>');		//text함수는 태그를 문자열로 출력함
		
		//=======================remove함수,empty함수============================
		//$('div').remove();	//div태그 자체를 지움
		$('div').empty();		//div태그의 내용만 지움
	});
</script>

<style type="text/css">
	.test{
		color : red;
	}
	div{
		width: 200px;
		height: 200px;
		border: 2px solid black;
	}
</style>
</head>
<body>
	<p> Test 문장</p>
	<a href="#none">하이퍼링ㅋ</a>
	<input type="checkbox" id="chk" scmaster="34기">
	
	<h1>Header - 0</h1>
	<h1>Header - 1</h1>
	<h1>Header - 2</h1>
	
	<div></div>
	<div></div>
	<div></div>
</body>
</html>