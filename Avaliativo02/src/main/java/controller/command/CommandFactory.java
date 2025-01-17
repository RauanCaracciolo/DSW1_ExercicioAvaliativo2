package controller.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CommandFactory {
	public static Command getCommand(String action, HttpServletRequest request, HttpServletResponse response) {
		if(action == null || action.isEmpty()) {
			return new DefaultCommand();
		}else {
			//Com base na ação, retorna um comando diferente
			switch(action) {
				case "login":{
					return new LoginCommand();
				}
				case "logout":{
					return new LogoutCommand();
				}
				case "registrarUsuario":{
					return new RegistrarUsuarioCommand();
				}
				case "registrarPedido":{
					return new RegistrarPedidoCommand();
				}
				case "deletarPedido":{
					return new DeletarPedidoCommand();
				}
				case "alterarPedido":{
					return new AlterarPedidoCommand();
				}
				case "consultarPedido":{
					return new ConsultarPedidoCommand();
				}
				case "relatorioGeral":{
					return new RelatorioGeralCommand();
				}
				case "relatorioCliente":{
					return new RelatorioClienteCommand();
				}
				default:{
					return new DefaultCommand();
					}
				}
		}	
	}
}
		