package pe.edu.upeu.ventas.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.ventas.entity.DetalleVenta;

public interface DetalleVentaDao {
	public int create(DetalleVenta u);
	public int update(DetalleVenta u);
	public int delete(int id);
	public DetalleVenta read(int id);
	public List<Map<String, Object>> readAll();
}
