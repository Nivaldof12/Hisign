<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<title>Horário</title>
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
	      <li><a href="/horario"><span class="glyphicon glyphicon-time"></span> Cadastrar Horário</a></li>
	      <li><a href="/teste"><span class="glyphicon glyphicon-list-alt"></span> Cadastrar Teste</a></li>
    </ul>
  </div>
</nav>

	<div class="container">

		<h3>Agendamentos</h3>
	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Entrada</th>
			      <th>Intervalo</th>
			      <th>Saida</th>
			      <th>Observação</th>
			      <th>Turno</th>
			      <th>Alterar</th>
			      <th></th>	  
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="h" items="${horarios}">
				    <tr>
				      <td>${h.id}</td>
				      <td>${h.entrada}</td>
				      <td>${h.intervalo}</td>
				      <td>${h.saida}</td>
				      <td>${h.observacao}</td>
				      <td>${h.turno}</td>
				      <td><a href="/horario/${h.id}/editar"> <span class="glyphicon glyphicon-pencil"></span></a></td>
				      <td><a href="/horario/${h.id}/excluir">excluir</a></td>				      
			    </c:forEach>
			  </tbody>
			</table>
	</div>

</body>
</html>