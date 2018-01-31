<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	
	//arguments
	function test1() {
		function sumAll() {
			alert(typeof(arguments) + ' : ' + arguments.length);
		}
		sumAll(1,2,3,4,5,6,7,8,9);
	}
	
	//callback함수
	function test2() {
		function callTenTimes(callfnc) {
			for(var i=0; i<10; i++){
				callfnc();
			}
		}
		
		var callback = function() {
			var test = 'aaa';
			alert('함수호출');
		};
		
		//callTenTimes(callback);
		//같은내용 다른선언방법
		callTenTimes(function() {
			var test = 'aaa';
			alert('함수호출');
		});
	}
	
	//타이머 함수
	function test3() {
		setTimeout(function() {
			alert('3초가 지났습니다. ㅇㅂㅇ');
		}, 3000);
		
		var intervalID = setInterval(function() {
			alert('<p>' + new Date() + '<p>');	//alert 떠있는 동안은 시간초가 지나지않음
		}, 1000);
		
		setTimeout(function() {
			clearInterval(intervalID);
			alert('종료');
		}, 10000);
	}
	
	//코드실행함수(eval)
	function test4() {
		var willEval = '';
		willEval += 'var num = 10;';
		willEval += 'alert(num)';
		//alert(num);	//에러
		eval(willEval);	//10
		alert(num);		//eval을 한번 실행한 다음부터는 그안에 있던 함수도 사용할수있다
	}
	
	//자바스크립트실행순서
	function test5() {
		alert('a');
		setTimeout(function() {
			alert('b');
		}, 0);
		alert('c');
		//a c b
		
		for(var i=0; i<3; i++){
			setTimeout(function () {
				alert(i);	//3 3 3
			}, 0);
		}
	}
	
	function test6() {
		var product = {
			name : '7D 건조 망고',
			type : '당절임',
			source : '망고, 설탕, 메타중아황산나트륨, 치자황색소',
			from : '필리핀'
		};
		
		alert(product);				//object
		alert(product['name']);		//7D 건조 망고
		alert(product.type);		//당절임
		alert(product['source']);	//망고, 설탕, 메타중아황산나트륨, 치자황색소
		alert(product['from']);		//필리핀
	}
	
	function test7() {
		var person = {
			name : '보노보노',
			eat : function(food) {
				alert(this.name + '가 ' + food + '을/를 먹습니다.');
			}
		};
		
		person.eat('조개구이');
	}
	
	//객체 추가, 삭제
	function test8() {
		var product = {
			name : 'MVS2015U',
			price : '1500원',
			lang : '한국어',
			supprotOS : 'Win 32/64',
			sub : true
		};
		
		//객체추가
		product.dd = 123;
		product.toString = function() {
			var output = '';
			
			for(var k in product){
				if(k != 'toString')
					output += 'ㅇ' + k +': ' + product[k] + '\n';
			}
			
			return output;
		};
		
		//객체삭제
		delete(product.price);
		
		alert(product.toString());
	}
	
	//sort정렬
	function test9() {
		var array = [52, 273, 103, 32];
		
		array.sort(function(left,right) {
			alert('left: ' + left);
			alert('right: ' +right);
			return left - right;
		});
		
		alert(array);
	}
	
	//forEach
	function test10() {
		var array = [1,2,3,4,5,6,7,8,9,10];
		
		var sum = 0;
		var output = '';
		array.forEach(function(ele, idx, array) {
			sum += ele;
			output += idx + ': ' + ele + ' -> ' + sum + '\n'; 
		});
		
		alert(output);
	}
</script>

</head>
<body>
	<a href="javascript:test1()">arguments</a><br>
	<a href="javascript:test2()">callback함수</a><br>
	<a href="javascript:test3()">타이머함수</a><br>
	<a href="javascript:test4()">코드실행함수(eval)</a><br>
	<a href="javascript:test5()">자바스크립트실행순서</a><br>
	<a href="javascript:test6()">객체</a><br>
	<a href="javascript:test7()">객체2</a><br>
	<a href="javascript:test8()">객체3</a><br>
	<a href="javascript:test9()">sort정렬</a><br>
	<a href="javascript:test10()">forEach</a><br>
</body>
</html>