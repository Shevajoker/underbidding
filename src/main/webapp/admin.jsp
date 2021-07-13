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
			<label class="form-label">Add product from anrex.info</label>
			<br>
			<input type="text" placeholder="Enter URL" name="urlAnrexInfo" size="100" required="required" class="form-control">
				<br>
				<input type="submit" class="btn btn-success">
		</form>
		<p style="color: green;">${message }</p>
		<br>
		
		<h2>smebel.su</h2>
		<form id="form-smebel" action="SmebelSu" method="post">
			<label class="form-label">Product from anrex.info</label>
			<br>
			<select	form="form-smebel" name="anrex-product" class="form-control">
				<c:forEach items="${products}" var="product">
					<option value="${product.article }">${product.name}</option>
				</c:forEach>
			</select> <br> <label class="form-label">Add product from smebel.su</label> <br>
			<input type="text" placeholder="Enter URL" name="urlSmebelSu" size="100" required="required" class="form-control">
			<br>
			<input type="submit" class="btn btn-success">
		</form>
		
		

		<br>
		<h2>ekat-mebel.ru</h2>
		<form id="form-ekat-mebel-ru" action="EkatMebelRu" method="post">
			<label class="form-label">Product from anrex.info</label>
			<br>
			<select	form="form-ekat-mebel-ru" name="anrex-product" class="form-control">
				<c:forEach items="${products}" var="product">
					<option value="${product.article }">${product.name}</option>
				</c:forEach>
			</select>
			<br>
			<label class="form-label">Add product from ekat-mebel.ru</label>
			<br>
			<input type="text" placeholder="Enter URL" name="ekatMebelRuUrl" size="100"	required="required" class="form-control">
				<br>
				<input type="submit" class="btn btn-success">
		</form>
		

		<br>
		<h2>mebelliner.ru</h2>
		<form id="form-mebellinerru" action="MebellinerRu" method="post">
			<label class="form-label">Product from anrex.info</label>
			<br>
			<select	form="form-mebellinerru" name="anrex-product" class="form-control">
				<c:forEach items="${products}" var="product">
					<option value="${product.article }">${product.name}</option>
				</c:forEach>
			</select>
			<br>
			<label class="form-label">Add product from mebelliner.ru</label>
			<br>
			<input type="text" placeholder="Enter URL" name="mebellinerRuUrl" size="100"	required="required" class="form-control">
				<br>
				<input type="submit" class="btn btn-success">
		</form>
		

	<div class="container footer" style="height: 300px">
	
	</div>
	
</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>