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
	<h1>Information</h1>

	<a href="index.jsp">Back</a>
	<br>
	<hr>

	<a href="information?data=smebel.su" class="btn btn-success">smebel.su</a>
	<a href="information?data=ekat-mebel.ru" class="btn btn-success"> ekat-mebel.ru </a>
	<a href="information?data=mebelliner.ru" class="btn btn-success"> mebelliner.ru </a>
	<a href="information?data=belsosna.ru" class="btn btn-success"> belsosna.ru </a>
	<a href="information?data=mebelluxe.com" class="btn btn-success"> mebelluxe.com </a>
	<a href="information?data=techshop.ru" class="btn btn-success"> techshop.ru </a>
	<a href="information?data=margomebel-msk.ru" class="btn btn-success"> margomebel-msk.ru </a>
	<a href="information?data=mebelfon.ru" class="btn btn-success"> mebelfon.ru </a>
	<a href="information?data=planeta-komforta.com" class="btn btn-success"> planeta-komforta.com </a>

<br>


	<br style="background: red">
	<hr>

	<table class="table">
		<thead>
			<tr>
				<td><c:out value="Article" /></td>
				<td><c:out value="Name" /></td>
				<td><c:out value="Actual price Anrex" /></td>
				<td><c:out value="Actual price ${data }" /></td>
				<td><c:out value="Old price Anrex" /></td>
				<td><c:out value="Old price ${data }" /></td>
				<td><c:out value="Url ${data }" /></td>
			</tr>
		</thead>
		<c:forEach items="${listShowTables}" var="list">
			<tr
				<c:if test="${list.priceActualAnrexProduct > list.priceActualOtherProduct}">
    			class="list-group-item-danger"
				</c:if>>
				<th scope="row"><c:out value="${list.articleNumber}" /></th>
				<td><c:out value="${list.nameProduct}" />
				<c:if test="${list.priceActualAnrexProduct > list.priceActualOtherProduct}">
    			<span class="badge bg-danger">${list.priceActualAnrexProduct - list.priceActualOtherProduct} ??????.</span>
				</c:if>
				</td>
				<td><c:out value="${list.priceActualAnrexProduct}" /></td>
				<td><c:out value="${list.priceActualOtherProduct}" /></td>
				<td><c:out value="${list.priceOldAnrexProduct}" /></td>
				<td><c:out value="${list.priceOldOtherProduct}" /></td>
				<td><a href=<c:out value="${list.urlOtherProduct}" />
					target="_blank">url</a></td>

			</tr>
		</c:forEach>

	</table>


</div>

</body>
</html>