package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.DatabaseUsuarioDao;
public class LoginCommand implements Command{
	private DatabaseUsuarioDao base = new DatabaseUsuarioDao();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		if(senha.equals(base.get(login))) {
			//Cria a sessão, caso o login esteja correto.
			HttpSession session = request.getSession();
			session.setAttribute("user", login);
			session.setMaxInactiveInterval(5 * 60);
			request.getRequestDispatcher("adm.jsp").forward(request, response);
		}
		response.sendRedirect("index.jsp");
		return null;
	}

}
