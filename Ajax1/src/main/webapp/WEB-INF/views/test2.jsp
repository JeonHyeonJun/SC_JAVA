<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TEST@</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript">
	$(function() {
		$('#formBtn1').on('click',function(){
			
			$.ajax({
				url : "insert1",
				type : "post",
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify({
					name : $('#name').val(),
					age : $('#age').val(),
					phone : $('#phone').val()
				}),
				dataType : "json",
				success : function(data) {
					alert("이름:" +JSON.stringify(data.name)+ "나이:" +JSON.stringify(data.age)+ "전화:" +JSON.stringify(data.phone));
				},
				error : function(e) {
					alert(JSON.stringify(e));
				}
			});
		});
		
		
		$('#formBtn3').on('click',function(){
			$.ajax({
				url : "insert3",
				type : "post",
				data : $('#writeForm3').serialize(),
				success : function(data) {
					alert("이름:" + data.name + "나이:" + data.age + "전화:" + data.phone);
				},
				error : function(e) {
					alert(JSON.stringify(e));
				}
			});
		});
		
		
		$('#btn1').on('click', function() {
			$.ajax({
				url : "jsontest",
				type : "get",
				dataType : "json",
				success : function(obj) {
					var str = "받은값: " +obj+ "<br>";
					str += "이름: " +obj.name+ "<br>";
					str += "나이: " +obj.age+ "<br>";
					str += "전화: " +obj.phone+ "<br>";
					
					$('#div1').html(str + '<img src='+obj.name+'>');
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

	<form id="writeForm1">
		이름 : <input type="text" id="name"><br>
		나이 : <input type="text" id="age"><br>
		전화 : <input type="text" id="phone"><br>
		<input type="button" value="저장" id="formBtn1">
	</form>
	
	<form id="writeForm3">
		이름 : <input type="text" id="name3" name="name"><br>
		나이 : <input type="text" id="age3" name="age"><br>
		전화 : <input type="text" id="phone3" name="phone"><br>
		<input type="button" value="저장" id="formBtn3">
	</form>
	
	<p>
		<input type="button" id="btn1" value="서버에서 객체 받기">
	</p>
	<div id="div1"></div>
</body>
</html>