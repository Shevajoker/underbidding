<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container-sm" style="margin-top: 100px">

		<h1>Hi Admin!</h1>

		<br> <a href="http://localhost:8080/ru.underbidding/">Back</a> <br>
		<hr>

		<form action="addArticleAnrexInfo" method="post">
			<label>Add product from anrex.info</label> <br> <input
				type="text" placeholder="Enter URL" name="urlAnrexInfo" size="100"
				required="required"> <br> <input type="submit">
		</form>
		<p style="color: green;">${message }</p>
		<br>
		<hr>

		<br>
		<h2>smebel.su</h2>
		<form id="form-smebel" action="SmebelSu" method="post">
			<label>Product from anrex.info</label> <br> <select
				form="form-smebel" name="anrex-product">
				<c:forEach items="${products}" var="product">
					<option value="${product.article }">${product.name}</option>
				</c:forEach>
			</select> <br> <label>Add product from smebel.su</label> <br> <input
				type="text" placeholder="Enter URL" name="urlSmebelSu" size="100"
				required="required"> <br> <input type="submit">
		</form>
		
		
		<hr>
		
		<br>
		<h2>ekat-mebel.ru</h2>
		<form id="form-ekat-mebel-ru" action="EkatMebelRu" method="post">
			<label>Product from anrex.info</label> <br> <select
				form="form-ekat-mebel-ru" name="anrex-product">
				<c:forEach items="${products}" var="product">
					<option value="${product.article }">${product.name}</option>
				</c:forEach>
			</select> <br> <label>Add product from ekat-mebel.ru</label> <br> <input
				type="text" placeholder="Enter URL" name="ekatMebelRuUrl" size="100"
				required="required"> <br> <input type="submit">
		</form>
		

	</div>
</body>
</html>