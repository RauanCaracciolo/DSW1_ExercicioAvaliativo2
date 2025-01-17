package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.DatabasePedidoDao;
import model.entity.Pedido;

public class ConsultarPedidoCommand implements Command {
	DatabasePedidoDao base = new DatabasePedidoDao();


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Pedido pedido = null;
		try {
			pedido = base.get(id);
			request.setAttribute("pedido", pedido);
			request.getRequestDispatcher("consultarPedido.jsp").forward(request, response);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
