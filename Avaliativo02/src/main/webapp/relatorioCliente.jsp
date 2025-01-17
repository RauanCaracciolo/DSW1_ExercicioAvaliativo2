<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %>
<%@ page import ="model.entity.Pedido" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Adm?action=relatorioCliente" method="post">
		<div>
			<label for="cliente">Digite o nome do cliente que deseja consultar:</label>
			<input id="cliente" name="cliente" >
		</div>
		<button type="submit">Gerar relatorio</button>
	</form>
	<br>
<%
	List<Pedido> pedidos = (List<Pedido>) request.getAttribute("lista");
	if(pedidos!= null){
		for(int i = 0; i < pedidos.size(); i++){
			out.println("<a>ID:" + pedidos.get(i).getIdpedidos() +"</a><br>");
			out.println("<a>Nome do cliente:" + pedidos.get(i).getNomeCliente() +"</a><br>");
			out.println("<a>Endereço de entrega:" + pedidos.get(i).getEnderecoEntrega() +"</a><br>");
			out.println("<a>Valor:" + pedidos.get(i).getValor() +"</a><br>");
			out.println("<a>Descricao:" + pedidos.get(i).getDescricao() +"</a><br>");
		}
	}
%>
	<a href="adm.jsp">Voltar a tela de admim</a>
</body>
</html>