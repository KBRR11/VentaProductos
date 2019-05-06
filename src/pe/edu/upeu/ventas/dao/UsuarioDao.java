package pe.edu.upeu.ventas.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.ventas.entity.Usuario;

public interface UsuarioDao {

	public int create(Usuario u);
	public int update(Usuario u);
	public int delete(int id);
	public Usuario read(int id);
	public Usuario Validar(String user, String clave);
	public List<Map<String, Object>> readAll();
	
}
