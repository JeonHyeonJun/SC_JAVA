<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>aa</title>

<script type="text/javascript">
	window.onload = function() {
		var header = document.getElementById("header");
		
		header.style.border = '2px solid black';
		header.style.color = 'orange';
		
		header.onclick = function(e) {
			var event = e || window.event;
			
			document.body.innerHTML = '';
			for(var key in event){
				document.body.innerHTML += '<p>' + key + ': ' +event[key] + '</p>';
			}
			alert(this);	
			header.onclick = null;
			this.style.cursor = 'pointer';
		};
	};
</script>
</head>
<body>
	<h1 id="header">Header</h1>
</body>
</html>