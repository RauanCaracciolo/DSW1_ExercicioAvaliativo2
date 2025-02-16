package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.DatabasePedidoDao;
import model.entity.Pedido;

public class AlterarPedidoCommand implements Command {
	DatabasePedidoDao base = new DatabasePedidoDao();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			int id = Integer.parseInt(request.getParameter("id"));
			String nome = request.getParameter("cliente");
			String endereco = request.getParameter("endereco");
			double valor = Double.parseDouble(request.getParameter("valor"));
			String descricao = request.getParameter("descricao");
			
			try {
				//Altera o pedido
				base.alter(id, new Pedido(id, nome, endereco, valor, descricao));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			request.getRequestDispatcher("alterarPedido.jsp").forward(request, response);
			return null;
	}

}
