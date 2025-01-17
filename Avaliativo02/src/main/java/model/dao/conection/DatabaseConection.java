package model.dao.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConection {
	//Parametros para conectar no MYSQL em meu computador
	private static String URL = "jdbc:mysql://localhost:3306/Avaliativo02";
	private static String USER = "root";
	private static String PASSWORD = "root";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		//Faz a conexão
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
		

}
