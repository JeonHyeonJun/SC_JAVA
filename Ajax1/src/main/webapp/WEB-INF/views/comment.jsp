<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댓 글 달 기</title>
<script type="text/javascript" src='<c:url value="/resources/js/jquery-3.2.1.js"/>'></script>
<script type="text/javascript">
	$(function() {
		init();
		
		$('#formButton').on('click', function() {
			var name = $('#name').val();
			var text = $('#text').val();
			
			if(name.length == 0){
				alert("이름을 입력하세욧");
				$('#name').focus();
				return;
			}
			else if(text.length == 0){
				alert("내용을 입력하세욧");
				$('#text').focus();
				return;
			}
			
			$.ajax({
				url : "insert",
				type : "post",
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify({
					name : name,
					text : text
				}),
				success : function() {
					alert("작성완료");
					$('#name').val('');
					$('#text').val('');
					init();
				},
				error : function() {
					alert("실패");
				}
			});
		});
		
		
	});
	
	//댓글 초기화
	function init(){
		$.ajax({
			url : "commentList",
			type : "get",
			dataType : "json",
			success : function(list) {
				$('#commentdiv').html('');
				var str = '<table border="1">'
				$.each(list, function(index, item) {
					str += '<tr>';
					str += '<td><font>' + item.name + '</font></td>';
					str += '<td id="text'+item.num+'">' + item.text + '</td>';
					str += '<td><input type="button" value="삭제" class="delBtn" num="'+item.num+'"></td>';
					str += '<td><input type="button" value="수정" class="updBtn" count="0" num="'+item.num+'" text="'+item.text+'"></td>';
					str += '</tr>';
				});
				str += '</table>';
				$('#commentdiv').html(str);
				
				$('.delBtn').on('click', function() {
					var num = $(this).attr("num");
					del(num);
				});
				
				$('.updBtn').on('click', function() {
					var num = $(this).attr("num");
					var text = $(this).attr("text");
					var count = $(this).attr("count");
					var str = '<textarea id="utxt'+num+'">'+text+'</textarea>';
					
					if(count == 1){
						var u_text = $('#utxt'+num).val();
						upd(num,u_text);
						$('#text'+num).html(text);
						$(this).attr("count", "0");
						return;
					}
					
					
					$('#text'+num).html(str);
					$(this).attr("count", "1");
					
				});
				
			},
			error : function() {
				alert("실패");
			}
		});
	}
	
	//댓글삭제
	function del(num) {
		if(confirm('삭제하시겠습니까?')){
			$.ajax({
				url : "delete",
				type : "post",
				data : {
					num : num
				},
				success : function() {
					alert("삭제완료");
					init();
				},
				error : function(e) {
					alert(JSON.stringify(e));
				}
			});
		}
	}
	
	//댓글수정
	function upd(num,text) {
		
			$.ajax({
				url : "update",
				type : "post",
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify({
					num : num,
					text : text
				}),
				success : function() {
					alert("수정완료");
					init();
				},
				error : function(e) {
					alert(JSON.stringify(e));
				}
			});
		
	}
</script>
<style>
	textarea {
		width: 500px;
		resize: none;
	}
	font {
		font-weight: bold;
		font-size: 20px;
		color : silver;
	}
</style>
</head>
<body>
	<div>
		<form action="writeForm">
			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" id="name" name="name"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea id="text" name="text"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="저장" id="formButton"></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="commentdiv">
		
	</div>
</body>
</html>