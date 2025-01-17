<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Adm?action=alterarPedido" method="post">
		<div>
			<label for="id">Id:</label>
			<input id="id" name="id" >
		</div>
		<div>
			<label for="cliente">Nome do Cliente:</label>
			<input id="cliente" name="cliente">
		</div>
		<div>
			<label for="endereco">Endereço da entrega:</label>
			<input id="endereco" name="endereco">
		</div>
		<div>
			<label for="valor">Valor:</label>
			<input id="valor"name="valor">
		</div>
		<div>
			<label for="descricao">Descricao:</label>
			<input id="descricao" name="descricao">
		</div>
		<button type="submit">Alterar pedido</button>
		<a href="adm.jsp">Voltar a tela de admim</a>
	</form>
</body>
</html>