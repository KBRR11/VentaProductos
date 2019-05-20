package pe.edu.upeu.ventas.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.ventas.entity.Producto;


public interface ProductoDao {

	public int create(Producto u);
	public int update(Producto u);
	public int updateCantidad(Producto u);
	public int delete(int id);
	public Producto read(int id);
	public List<Map<String, Object>> readAll();

	
}
