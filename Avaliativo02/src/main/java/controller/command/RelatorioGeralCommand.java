package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.DatabasePedidoDao;
import java.util.List;
import model.entity.Pedido;

public class RelatorioGeralCommand implements Command {
	DatabasePedidoDao base = new DatabasePedidoDao();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Pedido> lista = null;
		try {
			//Requisita para o model todos os pedidos e envia pra jsp
			lista = base.geralRelatory();
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("relatorioGeral.jsp").forward(request, response);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
