package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.DatabasePedidoDao;

public class DeletarPedidoCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DatabasePedidoDao base = new DatabasePedidoDao();

		int id = Integer.parseInt(request.getParameter("id"));
		try {
			base.delete(id);
			response.sendRedirect("deletarPedido.jsp");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
