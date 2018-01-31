<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" 
	contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	
	<script type="text/javascript">
		//alert("this is \"String\"");
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
		//test7();
		
		//typeof함수
		function test1() {
			alert(typeof("문자"));			//string
			alert(typeof(273));				//number
			alert(typeof(true));			//boolean
			alert(typeof( function() {}) );	//function
			alert(typeof( {} ));			//object
			alert(typeof(swimswim));		//undefined
		}
		
		//자료형의 덧셈
		function test2() {
			alert('52 + 273');				//52 + 273
			alert(52 + 273);				//325
			alert('52' + 273);				//52273
			alert(52 + '273');				//52273
			alert('52' + '273');			//52273
		}
		
		//형변환
		function test3() {
			alert(parseInt('52') + 273);	//325
			alert(Number('52') + 273);		//325
			//parseInt는 숫자가 아닌걸 형변환 할 경우 숫자였던곳까진 형변환시켜줌 
			alert(parseInt('oo2'));		//59
			//Number는 숫자가 아닌걸 형변환 할 경우 NaN이 나옴
			alert(Number('59o25'));			//NaN
			
			alert(isNaN(01073169979));		//false
			alert(isNaN(010-7316-9979));	//true;
		}
		
		//일치연산자
		function test4() {
			//자동으로 형변환해서 비교하므로 모두 true
			alert('' == false);				//true
			alert('' == 0);					//true
			alert(0 == false);				//true
			alert('273' == 273);			//true
			
			//자료형과 값을 모두 비교하므로 false 
			alert('' === false);			//false
			alert('' === 0);				//false
			alert(0 === false);				//false
			alert('273' === 273);			//false
		}
		
		//배열
		function test5() {
			//var array = [273, '스트링', true, function(){}, {}, [273,57]];
					   //273, 스트링,	  true, function(){}, object, 273,57
			/* for(var i=0; i<array.length; i++){
				alert(array[i]);
			} */
				 
			var array2 = [0, 1];
			array2.push(3);
			array2.push(2);
			array2.push(4);
			alert(array2);	//0,1,3,2,4
			
			for(var i in array2){
				alert(array2[i]);	//0,1,3,2,4
			}
			for(var i=0; i<array2.length; i++){
				alert(array2[i]);	//0,1,3,2,4
			}
		}
		
		//선언적함수, 익명함수
		function test6() {
			//선언적함수생성을 먼저 실행하고 위에서부터 차례대로 실행
			
			fnc();					//2 초코
			
			var fnc = function() {	//3
				var output = prompt('1+1은?', '숫자');
				alert(output);
			};
			
			function fnc() {		//1
				alert('초코');
			}
			
			fnc();					//4	1+1은?...
			
			//alert(fnc);
		}
		
		function test7() {
			var array1 = Array();
			var array2 = Array(10);
			var array3 = Array(273,103,57,32);
			
			alert(array1 + '\n' + array2 + '\n' + array3);
		}
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  <a href="day2">day2</a> </P>
<P>  <a href="day3">탈모빔</a> </P>
<P>  <a href="day4">day4</a> </P>
<P>  <a href="jQuery1">jQuery1</a> </P>
<P>  <a href="jQuery2">jQuery2</a> </P>
<P>  <a href="jQuery3">jQuery3</a> </P>
<P>  <a href="jQuery4">jQuery4</a> </P>
<P>  <a href="jQuery5">jQuery5</a> </P>
</body>
</html>
