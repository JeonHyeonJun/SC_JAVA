<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.high-light-0 {
		background : red;
	}
	.high-light-1 {
		background : blue;
	}
	.high-light-2 {
		background : yellow;
	}
	.high-light-3 {
		background : pink;
	}
	.high-light-4 {
		background : green;
	}
</style>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript">
	$(function() {
		$('input[type="text"]').val("Hell jQuery!");
		$('input:text').val("Hell JQERY");
		
		setTimeout(function() {
			var value = $('select > option:selected').val();
			//alert(value);
		}, 5000);
		
		var array = [
						1,
						2,
						object = {
								name : 'name',
								num : 20,
								bol : true,
								array : [1,2,3,4,5,6]
						},
						4,
						5,
						6
					];
		var object = {
			name : 'name',
			num : 20,
			bol : true,
			array : [1,2,3,4,5,6]
		};
		
		//자료형each문
		$.each(object, function(index, item) {
			console.log(index + " | " + item);	//f12 콘솔창에 log 띄움
		});
		$.each(array, function(index, item) {
			if(index == 2){
				console.log(item.num);
			}
			console.log(index + " | " + item);
		});
		
		//태그each문
		$('.p2').each(function(index, item) {
			if(index == 1){
				$(item).css('background', 'red');
			}
		});
		
		//하이퍼링크 추가하기
		var array = [
			{ name : 'Hanbit Media', link : 'http://www.hanbit.co.kr'},
			{ name : 'Naver', link : 'https://www.naver.com'},
			{ name : 'Daum', link : 'http://daum.net'}
		];
		$.each(array, function(index, item) {
			var output = '';
			output += '<a href="' + item.link +'">';
			output += '	<h2>' + item.name + '</h2>';
			output += '</a>';
			
			document.body.innerHTML += output;
		});
		
		//addClass(태그에 클래스 추가)
		$('h1').each(function(index,item) {
			$(item).addClass('high-light-'+index);
		});
		
		
	});
</script>
</head>
<body>
	<input type="text" name="input" id="idw" value="value">
	<input type="text" name="input" id="idw" value="value">
	
	<select>
		<option>사과</option>
		<option>빽</option>
		<option>고양이</option>
		<option>댕댕이</option>
		<option>꼬끼리</option>
	</select>
	
	<p class="p1">ptag1</p>
	<p class="p1">ptag1</p>
	<p class="p2">ptag2</p>
	<p class="p2">ptag2</p>
	<p class="p2">ptag2</p>
	
	<h1>item - 0</h1>
	<h1>item - 1</h1>
	<h1>item - 2</h1>
	<h1>item - 3</h1>
	<h1>item - 4</h1>

</body>
</html>