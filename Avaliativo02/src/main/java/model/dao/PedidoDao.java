package model.dao;

import java.util.List;

import model.entity.Pedido;

public interface PedidoDao {
	public boolean create(Pedido pedido);
	public void delete(int id);
	public void alter(int id, Pedido pedido);
	public List<Pedido> geralRelatory();
	public List<Pedido> clientRelatory(String cliente);
	public Pedido get(int id);
	
}
