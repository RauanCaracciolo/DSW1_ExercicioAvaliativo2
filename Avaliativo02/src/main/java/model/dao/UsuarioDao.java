package model.dao;

import model.entity.Usuario;

public interface UsuarioDao {
	public boolean create(Usuario user);
	public String get(String email);
	
}
