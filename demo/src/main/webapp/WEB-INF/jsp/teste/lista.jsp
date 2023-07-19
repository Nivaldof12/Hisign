<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Lista de Testes</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Horário</a>
			</div>

			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="/horario/lista">Horário</a></li>
				<li><a href="/teste/lista">Teste</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="/horario"><span
						class="glyphicon glyphicon-time"></span> Cadastrar Horário</a></li>
				<li><a href="/teste"><span
						class="glyphicon glyphicon-list-alt"></span> Cadastrar Teste</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">

		<h3>Atividades</h3>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome do Teste</th>
					<th>Descrição</th>
					<th>Anexo</th>
					<th>Link</th>
					<th>Equipe</th>
					<th></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="t" items="${testes}">
					<tr>
						<td>${t.id}</td>
						<td>${t.nometeste}</td>
						<td>${t.resumo}</td>
						<td>${t.fileData}</td>
						<td><a href=${t.linkgit}>${t.linkgit}</a></td>
						<td>${t.equipe}</td>
						<td><a href="/teste/${t.id}/excluir">excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>