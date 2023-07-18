<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Cadastro de Usuário</title>
</head>

<body>

	<div class="container">


		<form action="/horario/incluir" method="post">
			<h3>Cadastro de Horário</h3>
			<br>

			<div class="form-group">
				<label>Nome da atividade:</label> <input type="text" name="nome"
					value="Trilha de imersão Estágio" class="form-control">
			</div>

			<div class="form-group">
				<label>Inicio da atividade:</label> <input type="time" name="inicio">
			</div>

			<div class="form-group">
				<label>Fim da atividade:</label> <input type="time" name="fim">
			</div>

			<div class="form-group">
				<label>Data:</label> <input type="date" name="dia">
			</div>

			<div class="form-group">
				<label>Descrição:</label>
				<textarea name="descricao" class="form-control">Preciso ver as aulas da trilha de imersão</textarea>
			</div>


			<div class="form-group">
				<label>Tipo de atividade:</label> <select name="tipo"
					class="form-control">
					<option value="Estudar" selected>Estudar</option>
					<option value="Atividade">Atividade</option>
					<option value="Compromisso">Compromisso</option>
					<option value="Lembrete">Lembrete</option>
				</select>
			</div>

			<div class="form-group">
				<label>Link da Reunião (Opcional):</label> <input type="text"
					name="linkReuniao" value="https://meet.jit.si/HiPizza2023"
					class="form-control">
			</div>
			<button type="submit" class="btn btn-success">Cadastrar</button>
		</form>
	</div>
</body>

</html>