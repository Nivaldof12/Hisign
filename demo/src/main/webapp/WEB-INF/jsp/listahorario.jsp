<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
	      <li><a href="/horario"><span class="glyphicon glyphicon-time"></span> Cadastrar Horário</a></li>
    </ul>
  </div>
</nav>

	<div class="container">

		<h3>Agendamentos</h3>
	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Nome</th>
			      <th>Inicio</th>
			      <th>Fim</th>
			      <th>dia</th>
			      <th>Descrição</th>
			      <th>Tipo</th>
			      <th>Link</th>
			      <th></th>	  
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="h" items="${horarios}">
				    <tr>
				      <td>${h.id}</td>
				      <td>${h.nome}</td>
				      <td>${h.inicio}</td>
				      <td>${h.fim}</td>
				      <td>${h.dia}</td>
				      <td>${h.descricao}</td>
				      <td>${h.tipo}</td>
				      <td>${h.linkReuniao}</td>
				      <td><a href="/horario/${h.id}/excluir">excluir</a></td>				      
			    </c:forEach>
			  </tbody>
			</table>
	</div>

</body>
</html>