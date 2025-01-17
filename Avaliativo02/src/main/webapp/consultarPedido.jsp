<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.entity.Pedido" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Adm?action=consultarPedido" method="post">
		<div>
			<label for="id">Id do pedido a ser consultado:</label>
			<input id="id" name="id" >
		</div>
		<button type="submit">Consultar</button>
	</form>
	<%
		Pedido pedido = (Pedido) request.getAttribute("pedido");
		if(pedido != null){
			out.println("<a>ID:" + pedido.getIdpedidos() +"</a><br>");
			out.println("<a>Nome do cliente:" + pedido.getNomeCliente() +"</a><br>");
			out.println("<a>Endereço de entrega:" + pedido.getEnderecoEntrega() +"</a><br>");
			out.println("<a>Valor:" + pedido.getValor() +"</a><br>");
			out.println("<a>Descricao:" + pedido.getDescricao() +"</a><br>");

		}
	%>
	<a href="adm.jsp">Voltar a tela de adm</a>
</body>
</html>