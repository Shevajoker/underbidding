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
<title>Underbidding</title>
</head>
<body>


	<div class="container-sm text-center" style="margin-top: 100px">
		<div class="row">
			<div class="col align-self-center">
				<form action="information?data=" method="get" style="margin-bottom: 50px;">
					<input type="submit" value="Information" class="btn btn-success">
				</form>
				
				<form action="underbidding" method="post">
					<input type="submit" value="Admin" class="btn btn-danger">
				</form>

			</div>
			
		</div>
	</div>


</body>
</html>