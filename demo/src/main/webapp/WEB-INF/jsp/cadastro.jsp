<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Cadastro de Horário</title>
</head>

<body>

	<div class="container">

		<form action="/horario/incluir" method="post">
			<h3>Cadastro de Horário</h3>
			<br>

			<div class="form-group">
				<label>Entrada:</label> <input type="time" name="entrada">
			</div>

			<div class="form-group">
				<label>Intervalo:</label> <input type="time" name="intervalo">
			</div>

			<div class="form-group">
				<label>Saída:</label> <input type="time" name="saida">
			</div>

			<div class="form-group">
				<label>Observação:</label>
				<textarea name="observacao" class="form-control">Exemplo: Na terça eu vou entrar 08:00 e sair de 11:00 e volto 15:00 até as 18:00</textarea>
			</div>


			<div class="form-group">
				<label>Equipe Turno:</label> <select name="turno"
					class="form-control">
					<option value="Estudar">Matutina</option>
					<option value="Atividade" selected>Vespertino</option>
					<option value="Compromisso">Noturno</option>
				</select>
			</div>

			<button type="submit" class="btn btn-success">Cadastrar</button>
		</form>
	</div>
</body>

</html>