package pe.edu.upeu.ventas.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.ventas.entity.Producto;
import pe.edu.upeu.ventas.entity.Rol;

public interface RolDao {

	public int create(Rol u);
	public int update(Rol u);
	public int delete(int id);
	public Rol read(int id);
	public List<Rol> readAll();
}
