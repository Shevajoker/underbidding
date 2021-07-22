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
		<h2>${urlP}</h2>
		<p>
		<% out.println(request.getRequestURL()); %>
		</p>

		<br> <a href="index.jsp">Back</a> <br>
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
		<hr>
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
		<hr>
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
		<hr>

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
	
	
	<br>
	<hr>
	<br>
	
	<h2>belsosna.ru</h2>
		<form id="form-belsosnaru" action="BelsosnaRu" method="post">
			<label class="form-label">Product from anrex.info</label>
			<br>
			<select	form="form-belsosnaru" name="anrex-product" class="form-control">
				<c:forEach items="${products}" var="product">
					<option value="${product.article }">${product.name}</option>
				</c:forEach>
			</select>
			<br>
			<label class="form-label">Add product from belsosna.ru</label>
			<br>
			<input type="text" placeholder="Enter URL" name="belsosnaRuUrl" size="100"	required="required" class="form-control">
				<br>
				<input type="submit" class="btn btn-success">
		</form>
	
	<br>
	<hr>
	<br>
	<h2>mebelluxe.com</h2>
		<form id="form-mebelluxeCom" action="MebelluxeCom" method="post">
			<label class="form-label">Product from anrex.info</label>
			<br>
			<select	form="form-mebelluxeCom" name="anrex-product" class="form-control">
				<c:forEach items="${products}" var="product">
					<option value="${product.article }">${product.name}</option>
				</c:forEach>
			</select>
			<br>
			<label class="form-label">Add product from mebelluxe.com</label>
			<br>
			<input type="text" placeholder="Enter URL" name="mebelluxeComUrl" size="100"	required="required" class="form-control">
				<br>
				<input type="submit" class="btn btn-success">
		</form>
	
	
	
	<br>
	<hr>
	<br>
	<h2>techshop.ru</h2>
		<form id="form-techshopRu" action="TechshopRu" method="post">
			<label class="form-label">Product from anrex.info</label>
			<br>
			<select	form="form-techshopRu" name="anrex-product" class="form-control">
				<c:forEach items="${products}" var="product">
					<option value="${product.article }">${product.name}</option>
				</c:forEach>
			</select>
			<br>
			<label class="form-label">Add product from techshop.ru</label>
			<br>
			<input type="text" placeholder="Enter URL" name="techshopRuUrl" size="100"	required="required" class="form-control">
				<br>
				<input type="submit" class="btn btn-success">
		</form>
	
	
</div>	
	<div class="container footer" style="height: 300px">
	
	</div>
	
</body>

<!--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>-->
</html>