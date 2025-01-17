package model.dao;

import java.sql.SQLException;

import model.dao.conection.DatabaseConection;
import model.entity.Usuario;

public class DatabaseUsuarioDao implements UsuarioDao{
	//Criação de usuario
	@Override
	public boolean create(Usuario user) {
		if(user != null) {
			var sql = "INSERT INTO Usuario(login, senha) VALUES(?, ?)";
			int rows = -1;
			try{
				var connection = DatabaseConection.getConnection();
				var statement = connection.prepareStatement(sql);
				statement.setString(1, user.getLogin());
				statement.setString(2, user.getSenha());
				
				rows = statement.executeUpdate();
				
				statement.close();
				connection.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
			return rows >0;
					
		}else {
			return false;
		}
	}
	//Pega a senha do usuario pelo login dele
	public String get(String login) {
		String retorno = null;
		var sql = "SELECT senha FROM Usuario WHERE login = ?";
		try {
			var connection = DatabaseConection.getConnection();
			var statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			
			try(var result = statement.executeQuery()){
				if(result.next()) {
					retorno = result.getString("senha");
				}
			}
			statement.close();
			connection.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return retorno;
	}

}
