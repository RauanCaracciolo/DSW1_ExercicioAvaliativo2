package controller.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet Filter implementation class GeralFilter
 */
@WebFilter("/*")
public class GeralFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public GeralFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	 @Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {
	        HttpServletRequest httpRequest = (HttpServletRequest) request;
	        HttpServletResponse httpResponse = (HttpServletResponse) response;

	        String uri = httpRequest.getRequestURI();
	        String action = httpRequest.getParameter("action");
	        System.out.println(uri);
	        HttpSession session = httpRequest.getSession(false);

	        // Verifica se a pagina atual é a de login, ou se o usuario esta logado, assim todas as outras paginas ncecessitam que esteja logado para acessar
	        if (uri.endsWith("index.jsp")||(action != null && action.equals("login")) || (session != null && session.getAttribute("user") != null)) {
	            chain.doFilter(request, response); //Segue com a requisição normalmente
	        } else {
	            httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp"); //Volta a pagina de login
	        }
	    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
