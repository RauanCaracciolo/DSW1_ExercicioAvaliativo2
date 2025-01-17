package model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.LinkedList;


import model.dao.conection.DatabaseConection;
import model.entity.Pedido;

public class DatabasePedidoDao implements PedidoDao{
	@Override
	public boolean create(Pedido pedido) {
		if(pedido != null) {
			var sql = "INSERT INTO Pedido(idpedidos, nomeCliente, enderecoEntrega, valor, descricao) VALUES(?, ?, ?, ?, ?)";
			int rows = -1;
			try{
				var connection = DatabaseConection.getConnection();
				var statement = connection.prepareStatement(sql);
				statement.setInt(1, pedido.getIdpedidos());
				statement.setString(2, pedido.getNomeCliente());
				statement.setString(3, pedido.getEnderecoEntrega());
				statement.setDouble(4, pedido.getValor());
				statement.setString(5, pedido.getDescricao());
				
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
	@Override
	public void delete(int id) {
		var sql = "DELETE FROM Pedido WHERE idpedidos = ?";
		try {
			var connection = DatabaseConection.getConnection();
			var statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
			statement.close();
			connection.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}		
	}
	@Override
	public void alter(int id, Pedido pedido) {
		if(pedido != null) {
			var sql = "update Pedido set nomeCliente = ?, enderecoEntrega = ?, valor = ?, descricao = ? where idpedidos = ?";
			try{
				var connection = DatabaseConection.getConnection();
				var statement = connection.prepareStatement(sql);
				statement.setString(1, pedido.getNomeCliente());
				statement.setString(2, pedido.getEnderecoEntrega());
				statement.setDouble(3, pedido.getValor());
				statement.setString(4, pedido.getDescricao());
				statement.setInt(5, id);
				
				statement.executeUpdate();
				
				statement.close();
				connection.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	@Override
	public List<Pedido> geralRelatory() {
		var sql = "SELECT *  FROM Pedido";
		List<Pedido> retorno = new LinkedList<Pedido>();
		try {
			var connection = DatabaseConection.getConnection();
			var statement = connection.prepareStatement(sql);
			try(var result = statement.executeQuery()){
				while(result.next()) {
					retorno.add(new Pedido(result.getInt("idpedidos"), result.getString("nomeCliente"), result.getString("enderecoEntrega"), result.getDouble("valor"), result.getString("descricao")));
				}
			}
			statement.close();
			connection.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return retorno;
	}
	@Override
	public List<Pedido> clientRelatory(String cliente) {
		var sql = "SELECT *  FROM Pedido WHERE nomeCliente = ?";
		List<Pedido> retorno = new LinkedList<Pedido>();
		try {
			var connection = DatabaseConection.getConnection();
			var statement = connection.prepareStatement(sql);
			statement.setString(1, cliente);
			try(var result = statement.executeQuery()){
				while(result.next()) {
					retorno.add(new Pedido(result.getInt("idpedidos"), cliente, result.getString("enderecoEntrega"), result.getDouble("valor"), result.getString("descricao")));
				}
			}
			statement.close();
			connection.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return retorno;
	}
		
	@Override
	public Pedido get(int id) {
		var sql = "SELECT nomeCliente, enderecoEntrega, valor, descricao  FROM Pedido WHERE idpedidos = ?";
		try {
			var connection = DatabaseConection.getConnection();
			var statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			String nome = null, endereco = null, descricao = null;
			double valor = 1.1;
			
			try(var result = statement.executeQuery()){
				if(result.next()) {
					
					nome = result.getString("nomeCliente");
					endereco = result.getString("enderecoEntrega");
					descricao = result.getString("descricao");
					valor = result.getFloat("valor");
					return new Pedido(id, nome, endereco, valor, descricao);
				}
			}
			statement.close();
			connection.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
