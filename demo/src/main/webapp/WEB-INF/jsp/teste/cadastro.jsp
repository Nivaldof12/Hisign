<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Cadastro Teste</title>
</head>

<body>

	<div class="container">


		<form action="/teste/incluir" method="post">
			<h3>Cadastro Teste</h3>
			<br>

			<div class="form-group">
				<label>Nome Teste:</label> <input type="text" name="nometeste"
					value="Teste Full Stack" class="form-control">
			</div>

			<div class="form-group">
				<label>Resumo Atividade:</label>
				<textarea name="resumo" class="form-control">Abra o link do github para visualizar a atividade. boa sorte!</textarea>
			</div>
			<div class="form-group">
				<label>Enviar arquivo:</label> <input type="file" name="fileData"
					class="form-control">
			</div>

			<div class="form-group">
				<label>Link do Teste:</label> <input type="text" name="linkgit"
					value="https://github.com/Nivaldof12/Testettet"
					class="form-control">
			</div>

			<div class="form-group">
				<label>Tipo de atividade:</label> <select name="equipe"
					class="form-control">
					<option value="Front-end">Front-end</option>
					<option value="Back-end">Back-end</option>
					<option value="Full-Stack" selected>Full-Stack</option>
				</select>
			</div>

			<button type="submit" class="btn btn-success">Cadastrar</button>
		</form>
	</div>
</body>

</html>