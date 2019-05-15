package pe.edu.upeu.ventas.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.ventas.entity.Ventas;


public interface VentasDao {
	public int create(Ventas u);
	public int update(Ventas u);
	public int delete(int id);
	public List<Ventas> readByCliente(int id);
	public List<Map<String, Object>> readAll();
}
