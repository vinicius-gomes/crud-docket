<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lista - Docket</title>
<c:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css">
</head>
<body>
	
	<div class="container">
	<h1>Cartórios</h1>
	<div>${sucesso }</div>
		<table class="table table-bordered table-striped table-hover"
			method="get">
			<tr>
				<th>ID</th>
				<th>Nome</th>
			</tr>
			<c:forEach items="${cartorios }" var="cartorios">
				<tr>
					<th>${cartorios.id }</th>
					<th><a href="cartorios/detalhes/${cartorios.id}">${cartorios.name }</a></th>
					<th><a href="cartorios/delete/${cartorios.id }">delete</a></th>
					<th><a href="cartorios/edit/${cartorios.id }">edit</a></th>
				</tr>
			</c:forEach>
		</table>
		<a href="${s:mvcUrl('CC#form').build()}">Novo Cartório</a>
	</div>
	
</body>
</html>
