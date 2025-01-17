package controller.command;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.DatabasePedidoDao;
import model.entity.Pedido;

public class RelatorioClienteCommand implements Command {
	DatabasePedidoDao base = new DatabasePedidoDao();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Pedido> lista = null;
		String cliente = request.getParameter("cliente");
		try {
			//Requisita para o Dao todos os pedidos do cliente X
			lista = base.clientRelatory(cliente);
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("relatorioCliente.jsp").forward(request, response);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
