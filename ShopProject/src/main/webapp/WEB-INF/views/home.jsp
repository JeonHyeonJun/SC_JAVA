<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<!-- 470c22aada080760827dae30daa86ac4 -->
	<!-- http://openapi.11st.co.kr/openapi/OpenApiService.tmall?key=470c22aada080760827dae30daa86ac4&apiCode=ProductSearch&keyword=choco -->

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

</script>
</head>


<body>

    <!-- Navigation -->
    <nav class="navbar-light bg-light static-top">
      <div class="container">
        <a class="navbar-brand" href="#">S&C Master</a>
        
        <c:if test="${sessionScope.loginId == null }">
	        <a class="btn btn-primary" href="insertCustomerForm">회원가입</a>
	        <a class="btn btn-primary" href="loginForm">로그인</a>
        </c:if>
        <c:if test="${sessionScope.loginId != null }">
        	<font color="aqua">${sessionScope.loginName}</font>님 로그인중
        	<a class="btn btn-primary" href="logout">로그아웃</a>
        </c:if>
      </div>
    </nav>

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
	
	<div>
		<table border="1">
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>상품가격</th>
				<th>이미지</th>
				<th>판매자</th>
			</tr>
			<c:forEach items="${list }" var="list">
					<tr>
						<td>${list.productCode }</td>
						<td>${list.productName }</td>
						<td>${list.productPrice }</td>
						<td><img src="${list.productImage }" width="100px" height="100px"></td>
						<td>${list.seller }</td>
					</tr>
			</c:forEach>
		</table>
	</div>
    <!-- Bootstrap core JavaScript -->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>

