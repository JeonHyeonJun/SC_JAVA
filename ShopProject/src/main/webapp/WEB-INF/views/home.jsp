<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="top.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<!-- 470c22aada080760827dae30daa86ac4 -->
	<!-- http://openapi.11st.co.kr/openapi/OpenApiService.tmall?key=470c22aada080760827dae30daa86ac4&apiCode=ProductSearch&keyword=choco -->
	<!-- http://openapi.11st.co.kr/openapi/OpenApiService.tmall?key=470c22aada080760827dae30daa86ac4&apiCode=ProductInfo&productCode=1315151863 -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>메인페이지</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="resources/vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="resources/css/landing-page.min.css" rel="stylesheet">

<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript">
$(function() {
	var page = 1;
	var loading = true;
	$(document).scroll(function() {
	    var maxHeight = $(document).height();
	    var currentScroll = $(window).scrollTop() + $(window).height();
	    

	    if (maxHeight <= currentScroll + 100) {
	    	var text = $('#text').val();
	    	
	    	if(loading){
	    		page = page+1;
	    		loading = false;
	    		$('#loading').html('<h1>다음 페이지를 불러오는중....</h1>');
	    		$.ajax({
	    	    	url : "pageplus",
	    	    	type : "post",
	    	    	data : {
	    	    		page : page,
	    	    		text : text
	    	    	},
	    	    	dataType : "json",
	    	    	success : function(list) {
	    	    		$.each(list, function(index, item) {
	    	    			var str = '';
	    	    			if(index == 0){
	    	    				str += '<tr id="page'+page+'" test="'+item.productCode+'">';
	    	    			}
	    	    			else{
	    	    				str += '<tr>';
	    	    			}
	    	    			str	+= '<td width="10%">'+item.productCode+'</td>';
    						str	+= '<td width="60%"><a href="productView?productCode='+item.productCode+'&text=${text}">'+item.productName+'</a></td>';
    						str	+= '<td width="5%">'+item.productPrice+'</td>';
    						str	+= '<td width="7%"><img src="'+item.productImage+'" width="100px" height="100px" onerror="this.src=\'resources/img/no_image.jpg\'"></td>';
    						str	+= '<td width="10%">'+item.seller+'</td>';
    						   						
    						if("${sessionScope.loginId}" != ''){
								str += '<td width="8%"><a href="javascript:insertCart('+item.productCode+')">담기</a></td>';
    						}
    						
    						str	+= '</tr>';
						
	    	    			$('#page'+(page-1)).after(str);
						});
	    	    		   				
	    	    		
	    	    		
	    	    		$('#loading').html('');
	    	    		loading = true;
	    			},
	    			error : function(e) {
	    				alert(JSON.stringify(e));
	    			}
	    	    });
	    	}
	    }
	  });
});
	function insertCart(productCode) {
		$.ajax({
			url : "insertCart",
			type : "post",
			data : {
				productCode : productCode
			},
			success : function() {
				alert("장바구니에 등록되었습니다");
			},
			error : function() {
				alert("정보불러오기 실패");
			}
		});
	}
</script>
<style type="text/css">
	table{
		border-color: blue;
	}
</style>
</head>


<body>


    <!-- Masthead -->
    <header class="masthead text-white text-center">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-xl-9 mx-auto">
            <h1 class="mb-5" id="tt">상품검색</h1>
          </div>
          <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
            <form action="./" method="get">
              <div class="form-row">
                <div class="col-12 col-md-9 mb-2 mb-md-0">
                  <input type="text" name="text" id="text" class="form-control form-control-lg" placeholder="상품검색" value="${text }">
                </div>
                <div class="col-12 col-md-3">
                  <button type="submit" class="btn btn-block btn-lg btn-primary">검색</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </header>
	<br>
	<div>
		<c:if test="${list == null}">
			<h1 style="text-align: center">검색결과가없습니다.</h1>
		</c:if>
		<c:if test="${list != null }">
			<table border="3">
				<tr>
					<th>상품번호</th>
					<th>상품명</th>
					<th>상품<br>가격</th>
					<th>이미지</th>
					<th>판매자</th>
					<c:if test="${sessionScope.loginId != null }">
						<th>장바구니</th>
					</c:if>
				</tr>
				
				<c:forEach items="${list }" var="list" varStatus="index">
					<c:if test="${index.last }">
						<tr id="page1" test="${list.productCode }">
					</c:if>
					<c:if test="${!index.last }">
						<tr>
					</c:if>
							<td width="10%">${list.productCode }</td>
							<td width="60%"><a href="productView?productCode=${list.productCode }&text=${text}">${list.productName }</a></td>
							<td width="5%">${list.productPrice }</td>
							<td width="7%"><img src="${list.productImage }" width="100px" height="100px" onerror="this.src='resources/img/no_image.jpg'"></td>
							<td width="10%">${list.seller }</td>
							<c:if test="${sessionScope.loginId != null }">
								<td width="8%"><a href="javascript:insertCart(${list.productCode })">담기</a></td>
							</c:if>
						</tr>
				</c:forEach>
			</table>
			<div id="loading"></div>
		</c:if>
	</div>
    <!-- Bootstrap core JavaScript -->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>

