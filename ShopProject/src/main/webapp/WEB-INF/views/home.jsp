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
</head>


<body>


    <!-- Masthead -->
    <header class="masthead text-white text-center">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-xl-9 mx-auto">
            <h1 class="mb-5">상품검색</h1>
          </div>
          <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
            <form action="./" method="get">
              <div class="form-row">
                <div class="col-12 col-md-9 mb-2 mb-md-0">
                  <input type="text" name="text" class="form-control form-control-lg" placeholder="상품검색">
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
			<table border="1">
				<tr>
					<th>상품번호</th>
					<th>상품명</th>
					<th>상품가격</th>
					<th>이미지</th>
					<th>판매자</th>
					<c:if test="${sessionScope.loginId != null }">
						<th>장바구니</th>
					</c:if>
				</tr>
				
				<c:forEach items="${list }" var="list">
					
						<tr>
							<td width="10%">${list.productCode }</td>
							<td width="60%"><a href="productView?productCode=${list.productCode }">${list.productName }</a></td>
							<td width="5%">${list.productPrice }</td>
							<td width="7%"><img src="${list.productImage }" width="100px" height="100px"></td>
							<td width="10%">${list.seller }</td>
							<c:if test="${sessionScope.loginId != null }">
								<td width="8%"><a href="javascript:insertCart(${list.productCode })">담기</a></td>
							</c:if>
						</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
    <!-- Bootstrap core JavaScript -->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>

