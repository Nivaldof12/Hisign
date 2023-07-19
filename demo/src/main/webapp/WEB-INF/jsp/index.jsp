<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<title>Menu Hisig</title>
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



</body>
</html>