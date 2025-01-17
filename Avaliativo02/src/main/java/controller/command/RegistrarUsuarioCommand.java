package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.DatabaseUsuarioDao;
import model.entity.Usuario;

public class RegistrarUsuarioCommand implements Command {
	private DatabaseUsuarioDao base = new DatabaseUsuarioDao();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		try {
			//Registra o usuario
			base.create(new Usuario(login, senha));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		response.sendRedirect("usuario.jsp");
		return null;
	}
}
