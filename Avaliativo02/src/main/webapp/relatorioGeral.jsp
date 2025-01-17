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
<a href="Adm?action=relatorioGeral"><button>Gerar relatorio</button></a><br>
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