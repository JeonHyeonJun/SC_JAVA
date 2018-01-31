<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function(){
		var popups = [];
		var popup = window.open('popup', 'name', 'width=200,height=200');
		popups.push(popup);
		
		setInterval(function() {

			for(var i=0; i<popups.length; i++){
				var x = (Math.random()*700)+1;
				var y = (Math.random()*400)+1;
				popups[i].moveTo(x,y);
			}
			
		},100);
		
		setInterval(function() {
			var popup2 = window.open('popup', '', 'width=200,height=200');
			popups.push(popup2);
		}, 3000);
	};
</script>
</head>
<body>
	<h1>프로세스1</h1>
	<h2>프로세스2</h2>
</body>
</html>