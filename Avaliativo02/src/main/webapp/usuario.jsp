<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Adm?action=registrarUsuario" method="post">
		<div>
			<label for="login">Login:</label>
			<input id="login" name="login" >
		</div>
		<div>
			<label for="senha">Senha:</label>
			<input id="senha" name="senha">
		</div>
		<button type="submit">Cadastrar</button>
	</form>
	<a href="adm.jsp">Voltar a tela de admim</a>

</body>
</html>