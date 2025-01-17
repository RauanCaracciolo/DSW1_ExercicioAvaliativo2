<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Adm?action=deletarPedido" method="post">
		<div>
			<label for="id">Id do pedido a ser deletado:</label>
			<input id="id" name="id" >
		</div>
		<button type="submit">Deletar</button>
	</form>
	<a href="adm.jsp">Voltar a tela de adm</a>
</body>
</html>